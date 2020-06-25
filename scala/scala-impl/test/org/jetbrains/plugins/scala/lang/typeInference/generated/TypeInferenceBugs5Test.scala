package org.jetbrains.plugins.scala
package lang
package typeInference
package generated

import org.jetbrains.plugins.scala.lang.typeInference.testInjectors.{SCL9445Injector, SCL9532Injector, SCL9533Injector, SCL9865Injector}

abstract class TypeInferenceBugs5TestBase extends TypeInferenceTestBase {
  override def folderPath: String = super.folderPath + "bugs5/"
}

class TypeInferenceBugs5Test extends TypeInferenceBugs5TestBase {

  def testAnyPatternMatching(): Unit = doTest()

  def testAssignmentNotImported(): Unit = doTest()

  def testCloseable(): Unit = doTest()

  def testCompoundTypeConformance(): Unit = doTest()

  def testCompoundTypeUnapply(): Unit = doTest()

  def testCyclicGetClass(): Unit = doTest()

  def testDeeperLub(): Unit = doTest()

  def testDefaultParamInference(): Unit = doTest()

  def testEA52539(): Unit = doTest()

  def testExistentialConformance(): Unit = doTest()

  def testExistentialConformance2(): Unit = doTest()

  def testExpectedOption(): Unit = doTest()

  def testFakePrimitiveConversion(): Unit = doTest()

  def testForStmtBug(): Unit = doTest()

  def testFromTwitter(): Unit = doTest()

  def testImplicitClause(): Unit = doTest()

  def testImplicitlyAddedExtractor(): Unit = doTest()

  def testImplicitTest(): Unit = doTest()

  def testImplicitVsNone(): Unit = { doTest() }

  def testInfixApply(): Unit = doTest()

  def testJavaArrayType(): Unit = doTest()

  def testParametersLub(): Unit = doTest()

  def testParenthesisedUnderscore(): Unit = doTest()

  def testParenthesisedUnderscore2(): Unit = doTest()

  def testPatternInterpolation(): Unit = doTest()

  def testRecursiveFunction(): Unit = doTest()

  def testRepeatedParams(): Unit = doTest()

  def testRepeatedParamsResolve(): Unit = doTest()

  def testSCL1971(): Unit = doTest()

  def testSCL2055(): Unit = doTest()

  def testSCL2292(): Unit = doTest()

  def testSCL2929(): Unit = doTest()

  def testSCL2936(): Unit = doTest()

  def testSCL3052(): Unit = doTest()

  def testSCL3074(): Unit = doTest()

  def testSCL3288(): Unit = doTest()

  def testSCL2381A(): Unit = doTest()

  def testSCL2381B(): Unit = doTest()

  def testSCL2381C(): Unit = doTest()

  def testSCL2381D(): Unit = doTest()

  def testSCL2426(): Unit = doTest()

  def testSCL2480(): Unit = doTest()

  def testSCL2487(): Unit = doTest()

  def testSCL2493(): Unit = doTest()

  def testSCL2618(): Unit = doTest()

  def testSCL2656(): Unit = doTest()

  def testSCL2777A(): Unit = doTest()

  def testSCL2777B(): Unit = doTest()

  def testSCL3063(): Unit = doTest()

  def testSCL2806(): Unit = doTest()

  def testSCL2806B(): Unit = doTest()

  def testSCL2817(): Unit = doTest()

  def testSCL2820(): Unit = doTest()

  def testSCL2889(): Unit = doTest()

  def testSCL2893(): Unit = doTest()

  def testSCL3123(): Unit = doTest()

  def testSCL3213(): Unit = doTest()

  def testSCL3216(): Unit = doTest()

  def testSCL3275(): Unit = doTest()

  def testSCL3277(): Unit = doTest()

  def testSCL3278A(): Unit = doTest()

  def testSCL3328(): Unit = doTest()

  def testSCL3329(): Unit = doTest()

  def testSCL3330(): Unit = doTest()

  def testSCL3338(): Unit = doTest()

  def testSCL3343(): Unit = doTest()

  def testSCL3347(): Unit = doTest()

  def testSCL3351(): Unit = doTest()

  def testSCL3354(): Unit = doTest()

  def testSCL3367(): Unit = doTest()

  def testSCL3590(): Unit = doTest()

  def testSCL3372(): Unit = doTest()

  def testSCL3385(): Unit = doTest()

  def testSCL3394(): Unit = doTest()

  def testSCL3412(): Unit = doTest()

  def testSCL3414A(): Unit = doTest()

  def testSCL3414B(): Unit = doTest()

  def testSCL3414C(): Unit = doTest()

  def testSCL3414D(): Unit = doTest()

  def testSCL3414E(): Unit = doTest()

  def testSCL3414F(): Unit = doTest()

  def testSCL3414G(): Unit = doTest()

  def testSCL3426(): Unit = doTest()

  def testSCL3427(): Unit = doTest()

  def testSCL3429(): Unit = doTest()

  def testSCL3455(): Unit = doTest()

  def testSCL3460(): Unit = doTest()

  def testSCL3468(): Unit = doTest()

  def testSCL3470(): Unit = doTest()

  def testSCL3482(): Unit = doTest()

  def testSCL3487(): Unit = doTest()

  def testSCL3496(): Unit = doTest()

  def testSCL3512(): Unit = doTest()

  def testSCL3517A(): Unit = doTest()

  def testSCL3517B(): Unit = doTest()

  def testSCL3517C(): Unit = doTest()

  def testSCL3537(): Unit = doTest()

  def testSCL3540(): Unit = doTest()

  def testSCL3544(): Unit = doTest()

  def testSCL3549A(): Unit = doTest()

  def testSCL3549B(): Unit = doTest()

  def testSCL3552(): Unit = doTest()

  def testSCL3565(): Unit = doTest()

  def testSCL3567(): Unit = doTest()

  def testSCL3603A(): Unit = doTest()

  def testSCL3603B(): Unit = doTest()

  def testSCL3654(): Unit = doTest()

  def testSCL3654B(): Unit = doTest()

  def testSCL3730(): Unit = doTest()

  def testSCL3735(): Unit = doTest()

  def testSCL3766(): Unit = doTest()

  def testSCL3796(): Unit = doTest()

  def testSCL3801A(): Unit = doTest()

  def testSCL3801B(): Unit = doTest()

  def testSCL3833(): Unit = doTest()

  def testSCL3834(): Unit = doTest()

  def testSCL3845(): Unit = doTest()

  def testSCL3854(): Unit = doTest()

  def testSCL3865(): Unit = doTest()

  def testSCL3877(): Unit = doTest()

  def testSCL3893(): Unit = doTest()

  def testSCL3908A(): Unit = doTest()

  def testSCL3908B(): Unit = doTest()

  def testSCL3912(): Unit = doTest()

  def testSCL3975(): Unit = doTest()

  def testSCL4031(): Unit = doTest()

  def testSCL4040(): Unit = doTest()

  def testSCL4052(): Unit = doTest()

  def testSCL4065(): Unit = doTest()

  def testSCL4077(): Unit = doTest()

  def testSCL4092(): Unit = doTest()

  def testSCL4093(): Unit = doTest()

  def testSCL4095A(): Unit = doTest()

  def testSCL4095B(): Unit = doTest()

  def testSCL4095C(): Unit = doTest()

  def testSCL4095D(): Unit = doTest()

  def testSCL4095E(): Unit = doTest()

  def testSCL4139(): Unit = doTest()

  def testSCL4150A(): Unit = doTest()

  def testSCL4150B(): Unit = doTest()

  def testSCL4150C(): Unit = doTest()

  def testSCL4150D(): Unit = doTest()

  def testSCL4158(): Unit = doTest()

  def testSCL4163A(): Unit = doTest()

  def testSCL4163B(): Unit = doTest()

  def testSCL4163C(): Unit = doTest()

  def testSCL4163D(): Unit = doTest()

  def testSCL4163E(): Unit = doTest()

  def testSCL4163F(): Unit = doTest()

  def testSCL4163G(): Unit = doTest()

  def testSCL4169(): Unit = doTest()

  def testSCL4186(): Unit = doTest()

  def testSCL4200(): Unit = doTest()

  def testSCL4276(): Unit = doTest()

  def testSCL4282(): Unit = doTest()

  def testSCL4293(): Unit = doTest()

  def testSCL4312(): Unit = doTest()

  def testSCL4321(): Unit = doTest()

  def testSCL4324(): Unit = doTest()

  def testSCL4353A(): Unit = doTest()

  def testSCL4353B(): Unit = doTest()

  def testSCL4353C(): Unit = doTest()

  def testSCL4354(): Unit = doTest()

  def testSCL4357(): Unit = doTest()

  def testSCL4357B(): Unit = doTest()

  def testSCL4363A(): Unit = doTest()

  def testSCL4363B(): Unit = doTest()

  def testSCL4375(): Unit = doTest()

  def testSCL4380(): Unit = doTest()

  def testSCL4389(): Unit = doTest()

  def testSCL4416(): Unit = doTest()

  def testSCL4432(): Unit = doTest()

  def testSCL4451(): Unit = doTest()

  def testSCL4478(): Unit = doTest()

  def testSCL4482(): Unit = doTest()

  def testSCL4493(): Unit = doTest()

  def testSCL4500(): Unit = doTest()

  def testSCL4513(): Unit = doTest()

  def testSCL4545(): Unit = doTest()

  def testSCL4558(): Unit = doTest()

  def testSCL4559A(): Unit = doTest()

  def testSCL4559B(): Unit = doTest()

  def testSCL4589(): Unit = doTest()

  def testSCL4617(): Unit = doTest()

  def testSCL4650(): Unit = doTest()

  def testSCL4651(): Unit = doTest()

  def testSCL4656(): Unit = doTest()

  def testSCL4685(): Unit = doTest()

  def testSCL4695(): Unit = doTest()

  def testSCL4718(): Unit = doTest()

  def testSCL4740(): Unit = doTest()

  def testSCL4749(): Unit = doTest()

  def testSCL4801(): Unit = doTest()

  def testSCL4807(): Unit = doTest()

  def testSCL4809(): Unit = doTest()

  def testSCL4823(): Unit = doTest()

  def testSCL4891A(): Unit = doTest()

  def testSCL4897(): Unit = doTest()

  def testSCL4904(): Unit = doTest()

  def testSCL4938(): Unit = doTest()

  def testSCL5023(): Unit = doTest()

  def testSCL5029(): Unit = doTest()

  def testSCL5030(): Unit = doTest()

  def testSCL5033(): Unit = doTest()

  def testSCL5048(): Unit = doTest()

  def testSCL5048B(): Unit = doTest()

  def testSCL5055(): Unit = doTest()

  def testSCL5060(): Unit = doTest()

  def testSCL5081(): Unit = doTest()

  def testSCL5104(): Unit = doTest()

  def testSCL5144(): Unit = doTest()

  def testSCL5159(): Unit = doTest()

  def testSCL5180(): Unit = doTest()

  def testSCL5183(): Unit = {
    doTest(
      s"""
         |class D
         |def foo[Q >: List[T], T >: D](): Q = List(new D)
         |
        |val x = foo()
         |
        |${START}x$END
         |//List[D]
      """.stripMargin)
  }

  def testSCL5185(): Unit = doTest()

  def testSCL5192(): Unit = doTest()

  def testSCL5193(): Unit = doTest()

  def testSCL5197(): Unit = doTest()

  def testSCL5222(): Unit = doTest()

  def testSCL5247(): Unit = doTest()

  def testSCL5250(): Unit = doTest()

  def testSCL5269(): Unit = doTest()

  def testSCL5303(): Unit = doTest()

  def testSCL5356(): Unit = doTest()

  def testSCL5337(): Unit = doTest()

  def testSCL5361(): Unit = doTest()

  def testSCL5393(): Unit = doTest()

  def testSCL5429(): Unit = doTest()

  def testSCL5454(): Unit = doTest()

  def testSCL5472(): Unit = doTest()

  def testSCL5472A(): Unit = doTest()

  def testSCL5472B(): Unit = doTest()

  def testSCL5475(): Unit = doTest()

  def testSCL5489(): Unit = doTest()

  def testSCL5538(): Unit = doTest()

  def testSCL5594(): Unit = doTest()

  def testSCL5650A(): Unit = doTest()

  def testSCL5650B(): Unit = doTest()

  def testSCL5650C(): Unit = doTest()

  def testSCL5661(): Unit = doTest()

  def testSCL5669(): Unit = doTest()

  def testSCL5669B(): Unit = doTest()

  def testSCL5681(): Unit = doTest()

  def testSCL5729(): Unit = doTest()

  def testSCL5733(): Unit = doTest()

  def testSCL5736(): Unit = doTest()

  def testSCL5737(): Unit = doTest()

  def testSCL5738(): Unit = doTest()

  def testSCL5744(): Unit = doTest()

  def testSCL5834(): Unit = doTest()

  def testSCL5840(): Unit = doTest()

  def testSCL5854(): Unit = doTest(
    """
      |object SCL5854 {
      |
      |  case class MayErr[+E, +A](e: Either[E, A])
      |
      |  object MayErr {
      |    import scala.language.implicitConversions
      |    implicit def eitherToError[E, EE >: E, A, AA >: A](e: Either[E, A]): MayErr[EE, AA] = MayErr[E, A](e)
      |  }
      |
      |  abstract class SQLError
      |
      |  import scala.collection.JavaConverters._
      |  def convert = {
      |    val m = new java.util.HashMap[String, String]
      |    m.asScala.toMap
      |  }
      |
      |  /*start*/MayErr.eitherToError(Right(convert))/*end*/: MayErr[SQLError, Map[String, String]]
      |}
      |
      |//SCL5854.MayErr[SCL5854.SQLError, Map[String, String]]
    """.stripMargin
  )

  def testSCL5856(): Unit = doTest()

  def testSCL5982(): Unit = doTest()

  def testSCL6022(): Unit = doTest()

  def testSCL6025(): Unit = doTest()

  def testSCL6079(): Unit = doTest()

  def testSCL6089(): Unit = doTest()

  def testSCL6091(): Unit = doTest()

  def testSCL6116(): Unit = doTest()

  def testSCL6118(): Unit = doTest()

  def testSCL6118B(): Unit = doTest()

  def testSCL6123(): Unit = doTest()

  def testSCL6158(): Unit = doTest()

  def testSCL6169(): Unit = doTest()

  def testSCL6177(): Unit = doTest()

  def testSCL6195(): Unit = doTest()

  def testSCL6198(): Unit = doTest()

  def testSCL6235(): Unit = doTest()

  def testSCL6259(): Unit = doTest()

  def testSCL6270(): Unit = doTest()

  def testSCL6304(): Unit = doTest()

  def testSCL6309(): Unit = doTest()

  def testSCL6350(): Unit = doTest()

  def testSCL6386(): Unit = doTest()

  def testSCL6507(): Unit = doTest()

  def testSCL6511(): Unit = doTest()

  def testSCL6514(): Unit = doTest()

  def testSCL6541(): Unit = doTest()

  def testSCL6549(): Unit = doTest()

  def testSCL6601(): Unit = doTest()

  def testSCL6601B(): Unit = doTest()

  def testSCL6605A(): Unit = doTest()

  def testSCL6605B(): Unit = doTest()

  def testSCL6605C(): Unit = doTest()

  def testSCL6608(): Unit = doTest()

  def testSCL6608B(): Unit = doTest()

  def testSCL6660(): Unit = doTest()

  def testSCL6667(): Unit = doTest()

  def testSCL6730(): Unit = doTest()

  def testSCL6730B(): Unit = doTest()

  def testSCL6736(): Unit = {
    doTest(
      s"""val concatenate =  "%s%s" format (_: String, _: String )
          |${START}concatenate$END
          |//(String, String) => String""".stripMargin)
  }

  def testSCL6745(): Unit = doTest()

  def testSCL6786(): Unit = doTest()

  def testSCL6787(): Unit = doTest()

  def testSCL6807(): Unit = doTest()

  def testSCL6854(): Unit = doTest()

  def testSCL6885(): Unit = doTest()

  def testSCL6978(): Unit = doTest()

  def testSCL7008(): Unit = doTest()

  def testSCL7031(): Unit = doTest()

  def testSCL7036(): Unit = doTest()

  def testSCL7043(): Unit = doTest()

  def testSCL7100(): Unit = doTest()

  def testSCL7174(): Unit = doTest()

  def testSCL7192(): Unit = doTest()

  def testSCL7268(): Unit = doTest()

  def testSCL7278(): Unit = doTest()

  def testSCL7321(): Unit = doTest()

  def testSCL7322(): Unit = doTest()

  def testSCL7388(): Unit = doTest()

  def testSCL7388B(): Unit = doTest()

  def testSCL7388C(): Unit = doTest()

  def testSCL7404(): Unit = doTest()

  def testSCL7413(): Unit = doTest()

  def testSCL7502A(): Unit = doTest()

  def testSCL7518(): Unit = doTest()

  def testSCL7502B(): Unit = doTest()

  def testSCL7521(): Unit = doTest()

  def testSCL7521B(): Unit = doTest()

  def testSCL7544A(): Unit = doTest()

  def testSCL7544B(): Unit = doTest()

  def testSCL7604(): Unit = doTest()

  def testSCL7618(): Unit = doTest()

  def testSCL7805(): Unit = doTest()

  def testSCL7901(): Unit = doTest()

  def testSCL7927(): Unit = doTest()

  def testSCL8005(): Unit = doTest()

  def testSCL8005A(): Unit = doTest()

  def testSCL8036(): Unit = doTest()

  def testSCL8157A(): Unit = doTest()

  def testSCL8157B(): Unit = doTest()

  def testSCL8079(): Unit = doTest()

  def testSCL8119A(): Unit = doTest()

  def testSCL8119B(): Unit = doTest()

  def testSCL8178(): Unit = doTest()

  def testSCL8191(): Unit = doTest()

  def testSCL8232(): Unit = { doTest() }

  def testSCL8240(): Unit = doTest()

  def testSCL8241(): Unit = doTest()

  def testSCL8246(): Unit = doTest()

  def testSCL8261(): Unit = doTest()

  def testSCL8280(): Unit = doTest()

  def testSCL8282(): Unit = doTest()

  def testSCL8288(): Unit = doTest()

  def testSCL8317(): Unit = doTest()

  def testSCL8359(): Unit = doTest()

  def testSCL8398(): Unit = doTest()

  def testSCL5728(): Unit = doTest()

  def testSCL8705(): Unit = doTest(
    """
      |trait Ura[M[_]] { self =>
      |  type S
      |
      |  def start : M[S]
      |
      |  def foo = new Ura[M] {
      |    type S = (Ura.this.S, Int)
      |
      |    def start = /*start*/self.start/*end*/
      |  }
      |
      |}
      |//M[Ura.this.S]
    """.stripMargin
  )

  def testSCL8800(): Unit = doTest()

  def testSCL8933(): Unit = doTest()

  def testSCL8989(): Unit = doTest()

  def testSCL8995(): Unit = doTest()

  def testSCL9000(): Unit = doTest()

  def testSCL9052(): Unit = {
    doTest(
      s"""
         |case class Foo[T](a: T)
         |
         |class Bar[T] {
         |  def fix(in: List[Foo[T]]): List[Foo[T]] = {
         |    def it(i: List[Foo[T]], o: List[Foo[T]]): List[Foo[T]] = {
         |      in match {
         |        case c :: rest =>
         |          val x = c.copy()
         |          it(i.tail, $START(x :: o)$END)
         |      }}
         |    it(in, Nil)
         |}}
         |//List[Foo[T]]
      """.stripMargin)
  }

  def testSCL9181(): Unit = doTest()

  def testSCL9306A(): Unit = doTest()

  def testSCL9306B(): Unit = doTest()

  def testSCL9426(): Unit = doTest()

  def testSCL9445(): Unit = doInjectorTest(new SCL9445Injector)

  def testSCL9473(): Unit = doTest()

  def testSCL9532(): Unit = doInjectorTest(new SCL9532Injector)

  def testSCL9533(): Unit = doInjectorTest(new SCL9533Injector)

  def testSCL9865(): Unit = doInjectorTest(new SCL9865Injector)

  def testSCL9877(): Unit = doTest()

  def testSCL10037(): Unit = doTest {
    """
      |import scala.language.existentials
      |class SCL10037 {
      |
      |  trait A
      |
      |  trait B[a <: A]{
      |    def c:CWithA[a]
      |  }
      |
      |  trait C[a <: A, _ <: B[a]]
      |
      |  type BAny = B[_ <: A]
      |  type CWithA[a <: A] = C[a, _ <: B[a]]
      |  type CAny =  C[a, _ <: B[a]] forSome {type a <: A}
      |
      |  def f(c:CAny): Int = 1
      |  def f(s: String): String = s
      |  val b:BAny= null
      |  /*start*/f(b.c)/*end*/
      |}
      |//Int
    """.stripMargin.trim
  }

  def testSCL9877_1(): Unit = doTest()

  def testSCL9925(): Unit = {
    doTest(
      """
        |object SCL9925 {
        |
        |  abstract class Parser[+T] {
        |    def |[U >: T](x: => Parser[U]): Parser[U] = ???
        |  }
        |
        |  abstract class PerfectParser[+T] extends Parser[T]
        |
        |  implicit def parser2packrat[T](p: => Parser[T]): PerfectParser[T] = ???
        |
        |  def foo: PerfectParser[String] = ???
        |
        |  def foo1: PerfectParser[Nothing] = ???
        |
        |  def fooo4: PerfectParser[String] = /*start*/foo | foo1 | foo1/*end*/
        |}
        |
        |//SCL9925.PerfectParser[String]
      """.stripMargin)
  }

  def testSCL9929(): Unit = doTest()

  def testSOE(): Unit = doTest()

  def testSOE2(): Unit = doTest()

  def testSOEFix(): Unit = doTest()

  def testUnaryMethods(): Unit = doTest()

  def testTupleAnonymous(): Unit = doTest()

  def testTupleExpectedType(): Unit = doTest()

  def testTupleExpectedType2(): Unit = doTest()

  def test10471A(): Unit = {
    val code =
      """
        |package outer {
        |  package a {
        |    class Foo
        |  }
        |  package object a {
        |    class B
        |    implicit def string2Foo(s: String): Foo = new Foo
        |  }
        |}
        |
        |package b {
        |  import outer.a.Foo
        |
        |  object Moo {
        |    def baz(m: Foo): Foo = {
        |      /*start*/""/*end*/
        |    }
        |  }
        |}
        |//Foo
      """.stripMargin
    doTest(code)
  }

  def test10471B(): Unit = {
    val code =
      """
        |package outer {
        |
        |  import outer.a.c.Foo
        |  package a {
        |    package c {
        |      class Foo
        |
        |    }
        |  }
        |  package object a {
        |    implicit def string2Foo(s: String): Foo = new Foo
        |  }
        |}
        |
        |package b {
        |  import outer.a.c.Foo
        |
        |  object Moo {
        |    def baz(m: Foo): Foo = {
        |      /*start*/""/*end*/
        |    }
        |  }
        |}
        |//Foo
      """.stripMargin
    doTest(code)
  }

  def testEmptyImplicits(): Unit = {
    val code =
      """
        |trait A {
        |  def foo: Int = 1
        |}
        |
        |implicit class AExt(a: A) {
        |  def foo(x : Int = 1): Boolean = false
        |}
        |
        |val l : List[A] = List(new A {})
        |
        |/*start*/l.map(_.foo())/*end*/
        |//List[Boolean]
      """.stripMargin
    doTest(code)
  }

  def testEarlyDefRecursion(): Unit = doTest()

  def testSCL7474(): Unit = doTest(
    """
      | object Repro {
      |
      |   import scala.collection.generic.IsTraversableLike
      |
      |   def head[A](a: A)(implicit itl: IsTraversableLike[A]): itl.A = itl.conversion(a).head
      |
      |   val one: Int = /*start*/head(Vector(1, 2, 3))/*end*/
      | }
      |
      | //Int""".stripMargin
  )

  // wrong highlighting in scala lang 2.10.
  // 2.11, 2.12 - ok
  def testSCL9677(): Unit = doTest(
    s"""
       |import scala.concurrent.Future
       |
       |
       |val s = for (i <- 1 to 100) yield Future.successful(0)  // infers IndexedSeq[Future[Int]] correctly
       |
       |//Future.sequence(s) //correct
       |Future.sequence{${START}s$END}
       |
       |//IndexedSeq[Future[Int]]
    """.stripMargin)

  def testSCL11142(): Unit = {
    addFileToProject("Tier1.java",
      """public final class Tier1 {
        |    public static final class Tier2 {
        |        public static final class Tier3
        |    }
        |}""".stripMargin)

    doTest(
      """object SCL11142 {
        |  /*start*/new Tier1.Tier2.Tier3/*end*/
        |}
        |//Tier2.Tier3
      """.stripMargin)
  }

  def testSCL9432(): Unit = doTest {
    """
      |object SCL9432 {
      |  def f(int: Int): Option[Int] = if (int % 2 == 0) Some(int) else None
      |  def g(as: List[Int])(b: Int): Option[Int] = if (as contains b) None else f(b)
      |  /*start*/List(1) flatMap g(List(2, 4))/*end*/
      |}
      |//List[Int]
    """.stripMargin.trim
  }

  def testSCL7010(): Unit = doTest {
    """
      |object O {
      |    case class Z()
      |    def Z(i: Int) = 123
      |    val x: Int => Int = /*start*/Z/*end*/
      |  }
      |//Int => Int
    """.stripMargin.trim
  }

  def testSCL8267(): Unit = doTest()

  def testSCL9119(): Unit = doTest {
    """
      |object ApplyBug {
      |  class Foo {
      |    def apply(t: Int): Int = 2
      |  }
      |
      |  def foo = new Foo
      |  def a(i: Int): Int = /*start*/new Foo()(i)/*end*/
      |}
      |//Int
    """.stripMargin.trim
  }

  def testSCL9858(): Unit = doTest {
    """
      |trait TX {
      |  type T
      |}
      |
      |def recursiveFn(a: TX)(b: a.T): a.T = {
      |  val res: a.T = /*start*/recursiveFn(a)(b)/*end*/
      |  res
      |}
      |//a.T
    """.stripMargin.trim
  }

  def testSCL13718(): Unit = doTest {
    """
      |object SCL13718 {
      |  trait Foo[F <: Foo[F]]
      |
      |  trait View[F <: Foo[F]]
      |
      |  def test[F <: Foo[F]](view: View[F]): Bar[F] = {
      |    /*start*/new Bar(view).init()/*end*/
      |  }
      |
      |  class Bar[F <: Foo[F]](view: View[F]) {
      |    def init(): this.type = this
      |  }
      |}
      |//SCL13718.Bar[F]
    """.stripMargin.trim
  }

  def testSCL13790(): Unit = doTest {
    s"""trait A {
      |  val x: Int
      |}
      |
      |class B extends A {
      |  implicit def booleanToInt(b: Boolean): Int = b.compareTo(false)
      |
      |  override val x = ${START}false$END
      |}
      |//Int""".stripMargin
  }

  def testSCL6008(): Unit = doTest()

  def testSCL15739(): Unit = doTest {
    s"""
       |trait Element { self =>
       |  type T
       |  def *(other: Element { type T = self.T }): Element { type T = self.T } = ???
       |}
       |case class Column() extends Element
       |
       |class Columns {
       |  def value: Column { type T = Double } = ???
       |}
       |
       |class Builder[T] {
       |  def select(element: T => Element): Builder[T] = ???
       |}
       |
       |case class Constant[T0]() extends Element {
       |  override type T = T0
       |}
       |
       |object MCVE {
       |  def create[T](shape: T): Builder[T] = ???
       |
       |  implicit def toConstant[T](s: T): Constant[T] = ???
       |  ${START}create(new Columns).select(r => (r.value * r.value) * r.value)$END
       |}
       |//Builder[Columns]
       |""".stripMargin
  }

  def testSCL9857(): Unit = doTest()

  def testSCL16757(): Unit = doTest(
    s"""
      |trait SeqLike[+A, +Repr]
      |
      |trait Seq[+A] extends SeqLike[A, Seq[A]]
      |
      |object Nil extends SeqLike[Nothing, Seq[Nothing]]
      |
      |object :+ {
      |  def unapply[T,Coll <: SeqLike[T, Coll]](t: Coll with SeqLike[T, Coll]): Option[(Coll, T)] = ???
      |}
      |object Test {
      |  ${START}someUnresolvedName match {
      |    case b :+ c => b
      |    case a => Nil
      |  }$END
      |}
      |//this is a type of incorrect expression, it may change if type inference changes
      |//SeqLike[T, SeqLike[Any, Any]]
      |""".stripMargin
  )
}

class TypeInferenceBugs5Test_with_parser_combinators extends TypeInferenceBugs5TestBase {
  override protected def supportedIn(version: ScalaVersion): Boolean = version  <= LatestScalaVersions.Scala_2_10

  def testSCL3076(): Unit = doTest()

  def testSCL3555(): Unit = doTest()

  def testSCL3738(): Unit = doTest()

  def testSCL6157(): Unit = doTest()

  def testSCL6658(): Unit = doTest()
}

class TypeInferenceBug5Test_with_xml extends TypeInferenceBugs5TestBase {
  override protected def supportedIn(version: ScalaVersion): Boolean = version <= LatestScalaVersions.Scala_2_10

  def testSCL3542(): Unit = doTest()

  def testSCL3817(): Unit = doTest()

  def testSCL4981(): Unit = doTest()
}

class TypeInferenceBugs5_with_StreamWithFilter extends TypeInferenceBugs5TestBase {
  override protected def supportedIn(version: ScalaVersion): Boolean = version < LatestScalaVersions.Scala_2_12

  def testSCL5669A(): Unit = doTest()
}