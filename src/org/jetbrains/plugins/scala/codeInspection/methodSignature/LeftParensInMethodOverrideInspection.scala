package org.jetbrains.plugins.scala
package codeInspection.methodSignature

import com.intellij.codeInspection._
import codeInspection.InspectionsUtil
import org.jetbrains.plugins.scala.lang.psi.api.statements.ScFunction

class LeftParensInMethodOverrideInspection extends LocalInspectionTool {
  def getGroupDisplayName = InspectionsUtil.MethodSignature

  def getDisplayName = "Left parens in method override"

  def getShortName = getDisplayName

  override def isEnabledByDefault = true

  override def getStaticDescription =
    "Method left parens that is present in overriden method"

  override def getID = "LeftParensInMethodOverride"

  override def buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean) = VisitorWrapper {
    case f: ScFunction if !f.hasEmptyParens && !f.hasUnitReturnType =>
      f.superMethod match {
        case Some(method: ScFunction) if method.hasEmptyParens =>
          holder.registerProblem(f.nameId, getDisplayName, new AddParensQuickFix(f))
        case _ =>
      }
  }
}