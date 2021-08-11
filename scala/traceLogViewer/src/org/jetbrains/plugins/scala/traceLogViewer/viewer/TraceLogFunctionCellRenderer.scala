package org.jetbrains.plugins.scala.traceLogViewer.viewer

import org.jetbrains.plugins.scala.traceLogViewer.viewer.TraceLogFunctionCellRenderer._
import org.jetbrains.plugins.scala.traceLogger.protocol.StackTraceEntry

import java.awt.event.MouseEvent
import java.awt.{Color, Graphics}
import javax.swing.border.EmptyBorder

class TraceLogFunctionCellRenderer extends TraceLogBaseCellRenderer {
  override def setup(): Unit = {
    // if the method names is like org$jetbrains$blub$SomeObj$$method
    // transform it to SomeObj$$method
    def clipMethodName(methodName: String): String =
      methodName.split("(?<!\\$)\\$(?!\\$)").last

    this.setText(
      if (currentNode.msg != null) ""
      else currentNode.stackTrace.headOption.fold("<root>")(se => clipMethodName(se.method))
    )
    this.setBorder(new EmptyBorder(0, indentSize * (currentNode.depth + 1) + 3, 0, 0))
  }

  override def getToolTipText(event: MouseEvent): String = {
    val builder = new StringBuilder

    var maxLines = 50

    def addEntry(entry: StackTraceEntry, bold: Boolean = false): Unit = {
      if (maxLines <= 0) {
        return
      }
      maxLines -= 1

      if (bold) {
        builder.append("<b>")
      }
      builder.append(entry.className)
      builder.append('.')
      builder.append(entry.method)
      builder.append(" (line ")
      builder.append(entry.line)
      builder.append(")")
      if (bold) {
        builder.append("</b>")
      }
      builder.append("<br />\n")
    }

    builder.append("<html>")

    for (entry <- currentNode.newStackTrace) {
      addEntry(entry, bold = true)
    }

    for (entry <- currentNode.parentStackTrace) {
      addEntry(entry)
    }

    builder.append("</html>")

    builder.toString()
  }

  override def paintComponent(g: Graphics): Unit = {
    super.paintComponent(g)

    def color(depth: Int) = colors(depth % colors.size)

    val saveColor = g.getColor
    val height = getHeight

    //if (!currentNode.isLeaf) {
    //  g.setColor(color(currentNode.depth))
    //  g.fillRect(0, 0, width, height)
    //}
    def drawIndent(i: Int, color: Color): Unit = {
      g.setColor(color)
      g.fillRect(i * indentSize, 0, indentSize, height)
    }
    val depth = currentNode.depth
    for (i <- 0 until depth)
      drawIndent(i, color(i))
    drawIndent(depth, if (currentNode.isLeaf) Color.LIGHT_GRAY else color(depth))

    g.setColor(saveColor)
  }
}

object TraceLogFunctionCellRenderer {
  val colors = Seq(
    Color.GREEN.darker().darker(),
    Color.RED.darker().darker(),
    Color.YELLOW.darker().darker(),
    Color.CYAN.darker().darker(),
  )

  val indentSize = 4
}