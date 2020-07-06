package org.jetbrains.plugins.scala
package lang
package psi
package impl
package expr

import com.intellij.lang.ASTNode
import com.intellij.psi._
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.IncorrectOperationException
import javax.swing.Icon
import org.jetbrains.plugins.scala.caches.CachesUtil
import org.jetbrains.plugins.scala.extensions._
import org.jetbrains.plugins.scala.icons.Icons
import org.jetbrains.plugins.scala.lang.lexer.ScalaTokenType
import org.jetbrains.plugins.scala.lang.psi.api.ScalaElementVisitor
import org.jetbrains.plugins.scala.lang.psi.api.base.types.ScTypeElement
import org.jetbrains.plugins.scala.lang.psi.api.base.{JavaConstructor, ScConstructorInvocation, ScalaConstructor}
import org.jetbrains.plugins.scala.lang.psi.api.expr._
import org.jetbrains.plugins.scala.lang.psi.api.statements.{ScDeclaredElementsHolder, ScTypeAlias}
import org.jetbrains.plugins.scala.lang.psi.api.toplevel.ScEarlyDefinitions
import org.jetbrains.plugins.scala.lang.psi.api.toplevel.templates.ScTemplateBody
import org.jetbrains.plugins.scala.lang.psi.api.toplevel.typedef.ScMember
import org.jetbrains.plugins.scala.lang.psi.impl.ScalaPsiElementFactory.createExpressionWithContextFromText
import org.jetbrains.plugins.scala.lang.psi.impl.toplevel.typedef.{ScTemplateDefinitionImpl, TypeDefinitionMembers}
import org.jetbrains.plugins.scala.lang.psi.stubs.ScTemplateDefinitionStub
import org.jetbrains.plugins.scala.lang.psi.stubs.elements.ScTemplateDefinitionElementType
import org.jetbrains.plugins.scala.lang.psi.types._
import org.jetbrains.plugins.scala.lang.psi.types.api.AnyRef
import org.jetbrains.plugins.scala.lang.psi.types.result._
import org.jetbrains.plugins.scala.macroAnnotations.{CachedInUserData, ModCount}

/**
* @author Alexander Podkhalyuzin
* Date: 06.03.2008
*/
final class ScNewTemplateDefinitionImpl(stub: ScTemplateDefinitionStub[ScNewTemplateDefinition],
                                        nodeType: ScTemplateDefinitionElementType[ScNewTemplateDefinition],
                                        node: ASTNode,
                                        debugName: String)
  extends ScTemplateDefinitionImpl(stub, nodeType, node, debugName)
    with ScNewTemplateDefinition {

  override protected def targetTokenType: ScalaTokenType = ScalaTokenType.NewKeyword

  override def getIcon(flags: Int): Icon = Icons.CLASS

  override def constructorInvocation: Option[ScConstructorInvocation] =
    Option(extendsBlock)
      .flatMap(_.templateParents)
      .filter(_.typeElements.length == 1)
      .flatMap(_.constructorInvocation)

  override protected def updateImplicitArguments(): Unit = {
    // for regular case implicits are owned by ScConstructor
    setImplicitArguments(desugaredApply.flatMap(_.findImplicitArguments))
  }

  protected override def innerType: TypeResult = {
    def filterTypeSignatures(aliases: Seq[ScTypeAlias]): Map[String, TypeAliasSignature] = {
      lazy val sigs = TypeDefinitionMembers.getTypes(this)
      aliases.flatMap { alias =>
        val sig            = TypeAliasSignature(alias)
        lazy val hasSupers = sigs.forName(alias.name).findNode(alias).exists(_.supers.nonEmpty)

        if (!alias.isPrivate && !alias.isProtected && !hasSupers) Option((alias.name, sig))
        else                                                      None
      }.toMap
    }

    def filterTermSignatures(terms: Seq[ScDeclaredElementsHolder]): Map[TermSignature, ScType] = {
      lazy val sigs = TypeDefinitionMembers.getSignatures(this)
      val termSigs  = ScCompoundType.signaturesFromPsi(terms)

      termSigs.filterNot { case (sig, _) =>
        val isAvalableOutside = sig.namedElement match {
          case m: ScMember => !m.isPrivate && !m.isProtected
          case _           => false
        }

        !isAvalableOutside || sigs.forName(sig.name).findNode(sig.namedElement).exists(_.supers.nonEmpty)
      }
    }

    // Reliably prevent cases like SCL-17168
    if (extendsBlock.getTextLength == 0) {
      return Failure("Empty new expression")
    }

    desugaredApply match {
      case Some(expr) => return expr.getNonValueType()
      case _          =>
    }

    val earlyHolders: Seq[ScDeclaredElementsHolder] = extendsBlock.earlyDefinitions match {
      case Some(e: ScEarlyDefinitions) =>
        e.members.flatMap {
          case holder: ScDeclaredElementsHolder => Seq(holder)
          case _                                => Seq.empty
        }
      case None => Seq.empty
    }

    val (termSignatures, typeSignatures) =
      extendsBlock.templateBody match {
        case Some(b: ScTemplateBody) =>
          val termSigs = filterTermSignatures(b.holders ++ earlyHolders)
          val typeSigs = filterTypeSignatures(b.aliases)
          (termSigs, typeSigs)
        case None => (ScCompoundType.signaturesFromPsi(earlyHolders), Map.empty[String, TypeAliasSignature])
      }

    val superTypes = extendsBlock.superTypes
    val superTypeElements = extendsBlock.templateParents.fold(Seq.empty[ScTypeElement])(_.allTypeElements)

    if (superTypeElements.length > 1 || termSignatures.nonEmpty || typeSignatures.nonEmpty) {
      Right(ScCompoundType(superTypes, termSignatures, typeSignatures))
    } else if (superTypeElements.length == 1) {
      superTypeElements.head.getNonValueType()
    } else {
      superTypes.headOption match {
        case Some(t) => Right(t)
        case None    => Right(AnyRef) //this is new {} case
      }
    }
  }

  override def desugaredApply: Option[ScExpression] = {
    if (constructorInvocation.forall(_.arguments.size <= 1)) None
    else cachedDesugaredApply
  }

  //It's very rare case, when we need to desugar `.apply` first.
  @CachedInUserData(this, ModCount.getBlockModificationCount)
  private def cachedDesugaredApply: Option[ScExpression] = {
    val resolvedConstructor = constructorInvocation.flatMap(_.reference).flatMap(_.resolve().toOption)
    val constrParamLength = resolvedConstructor.map {
      case ScalaConstructor(constr)         => constr.effectiveParameterClauses.length
      case JavaConstructor(_)               => 1
      case _                                => -1
    }
    val excessArgs =
      for {
        arguments   <- constructorInvocation.map(_.arguments)
        paramLength <- constrParamLength
        if paramLength >= 0
      } yield {
        arguments.drop(paramLength)
      }

    excessArgs match {
      case Some(args) if args.nonEmpty =>
        val desugaredText = {
          val firstArgListOfApply = args.head
          val startOffsetInThis   = firstArgListOfApply.getTextRange.getStartOffset - this.getTextRange.getStartOffset

          val thisText            = getText
          val newTemplateDefText  = thisText.substring(0, startOffsetInThis)
          val applyArgsText       = thisText.substring(startOffsetInThis)

          s"($newTemplateDefText)$applyArgsText"
        }

        createExpressionWithContextFromText(desugaredText, getContext, this).toOption
      case _ => None
    }
  }

 override def processDeclarationsForTemplateBody(processor: PsiScopeProcessor, state: ResolveState,
                                          lastParent: PsiElement, place: PsiElement): Boolean =
  extendsBlock.templateBody match {
    case Some(body) if PsiTreeUtil.isContextAncestor(body, place, false) =>
      super.processDeclarationsForTemplateBody(processor, state, lastParent, place)
    case _ => true
  }

  override def nameId: PsiElement = null
  override def setName(name: String): PsiElement = throw new IncorrectOperationException("cannot set name")
  override def name: String = "<anonymous>"

  override def getName: String = name

  override def getSupers: Array[PsiClass] = {
    extendsBlock.supers.filter { clazz =>
      clazz != this
    }.toArray
  }

  override def processDeclarations(processor: PsiScopeProcessor,
                                   state: ResolveState,
                                   lastParent: PsiElement,
                                   place: PsiElement): Boolean =
    processDeclarationsImpl(processor, state, lastParent, place)

  override def getExtendsListTypes: Array[PsiClassType] = innerExtendsListTypes

  override def getImplementsListTypes: Array[PsiClassType] = innerExtendsListTypes

  override def getTypeWithProjections(thisProjections: Boolean = false): TypeResult = `type`() //no projections for new template definition

  override protected def acceptScala(visitor: ScalaElementVisitor): Unit = {
    visitor.visitNewTemplateDefinition(this)
  }

  override protected def isInterface(namedElement: PsiNamedElement): Boolean = false

  @CachedInUserData(this, CachesUtil.libraryAwareModTracker(this))
  override def psiMethods: Array[PsiMethod] = getAllMethods.filter(_.containingClass == this)
}
