package org.jetbrains.plugins.scala
package lang
package parser
package parsing
package statements

import org.jetbrains.plugins.scala.lang.parser.parsing.base.Modifier
import org.jetbrains.plugins.scala.lang.parser.parsing.builder.ScalaPsiBuilder
import org.jetbrains.plugins.scala.lang.parser.parsing.expressions.Annotations
import org.jetbrains.plugins.scala.lang.parser.parsing.top.TmplDef

/**
 *
 * [[Def]] ::= [ [[Annotations]] {Modifier}]
 *          ('val' ValDef
 *         | 'var' VarDef
 *         | 'def' FunDef
 *         | 'def' MacroDef
 *         | 'type' {nl} TypeDef)
 *
 * @author Alexander Podkhalyuzin
 *         Date: 11.02.2008
 */
object Def extends ParsingRule {

  import lexer.ScalaTokenType._
  import lexer.ScalaTokenTypes

  override def apply()(implicit builder: ScalaPsiBuilder): Boolean = {
    val defMarker = builder.mark
    defMarker.setCustomEdgeTokenBinders(ScalaTokenBinders.PRECEDING_COMMENTS_TOKEN, null)
    Annotations.parseAndBindToLeft()(builder)

    val modifierMarker = builder.mark
    def parseScalaMetaInline(): Boolean = builder.isMetaEnabled && builder.tryParseSoftKeyword(ScalaTokenTypes.kINLINE)
    while (Modifier() || parseScalaMetaInline()) {}
    modifierMarker.done(ScalaElementType.MODIFIERS)

    //Look for val,var,def or type
    builder.getTokenType match {
      case ScalaTokenTypes.kVAL =>
        builder.advanceLexer() //Ate val
        if (PatDef.parse(builder)) {
          defMarker.done(ScalaElementType.PATTERN_DEFINITION)
          true
        }
        else {
          defMarker.rollbackTo()
          false
        }
      case ScalaTokenTypes.kVAR =>
        builder.advanceLexer() //Ate var
        if (VarDef.parse(builder)) {
          defMarker.done(ScalaElementType.VARIABLE_DEFINITION)
          true
        }
        else {
          defMarker.rollbackTo()
          false
        }
      case ScalaTokenTypes.kDEF =>
        if (MacroDef.parse(builder)) {
          defMarker.done(ScalaElementType.MACRO_DEFINITION)
          true
        } else if (FunDef.parse(builder)) {
          defMarker.done(ScalaElementType.FUNCTION_DEFINITION)
          true
        } else {
          defMarker.rollbackTo()
          false
        }
      case ScalaTokenTypes.kTYPE =>
        if (TypeDef.parse(builder)) {
          defMarker.done(ScalaElementType.TYPE_DEFINITION)
          true
        }
        else {
          defMarker.rollbackTo()
          false
        }
      case ScalaTokenTypes.kCASE | IsTemplateDefinition() =>
        defMarker.rollbackTo()
        TmplDef()
      case _ =>
        defMarker.rollbackTo()
        false
    }
  }
}

