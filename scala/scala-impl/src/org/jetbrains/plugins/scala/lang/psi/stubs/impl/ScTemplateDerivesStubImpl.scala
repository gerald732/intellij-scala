package org.jetbrains.plugins.scala.lang.psi.stubs.impl

import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.{IStubElementType, StubBase, StubElement}
import org.jetbrains.plugins.scala.lang.psi.api.toplevel.templates.ScTemplateDerives
import org.jetbrains.plugins.scala.lang.psi.stubs.ScTemplateDerivesStub

class ScTemplateDerivesStubImpl(parent: StubElement[_ <: PsiElement],
                                elementType: IStubElementType[_ <: StubElement[_ <: PsiElement], _ <: PsiElement])
  extends StubBase[ScTemplateDerives](parent, elementType) with ScTemplateDerivesStub
