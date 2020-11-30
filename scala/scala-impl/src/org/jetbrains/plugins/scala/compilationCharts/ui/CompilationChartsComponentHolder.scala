package org.jetbrains.plugins.scala.compilationCharts.ui

import com.intellij.openapi.components.{Service, ServiceManager}
import com.intellij.openapi.project.Project

@Service
final class CompilationChartsComponentHolder {
  private var mainComponent: Option[CompilationChartsComponent] = None

  private def createOrGet(project: Project): CompilationChartsComponent = synchronized {
    mainComponent.getOrElse {
      val component = new CompilationChartsComponent(project)
      component.updateData(System.nanoTime())
      mainComponent = Some(component)
      component
    }
  }
}

object CompilationChartsComponentHolder {

  def createOrGet(project: Project): CompilationChartsComponent =
    ServiceManager.getService(project, classOf[CompilationChartsComponentHolder]).createOrGet(project)
}
