package org.jetbrains.plugins.scala.lang

package object dfa {

  object Messages {
    val ConditionAlwaysTrue = "Condition is always true"
    val ConditionAlwaysFalse = "Condition is always false"
    val InvocationIndexOutOfBounds = "Invocation will produce IndexOutOfBoundsException. Index is always out of bounds"
    val InvocationNoSuchElement = "Invocation will produce NoSuchElementException. Collection is always empty"
  }

  def defaultCodeTemplate(returnType: String)(body: String): String =
    s"""
       |import java.util
       |import java.lang.Math._
       |
       |class OtherClass {
       |  val otherField: Int = 1244
       |  val yetAnotherField: String = "Hello again"
       |}
       |
       |class TestClass {
       |  def testMethod(arg1: Int, arg2: Int, arg3: Boolean, arg4: String): $returnType = {
       |    $body
       |  }
       |
       |  def anotherMethod(arg1: Int, arg2: Int, arg3: Boolean, arg4: String): Int = arg2 - arg1
       |}
       |""".stripMargin
}
