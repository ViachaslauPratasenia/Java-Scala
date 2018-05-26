package test.scala


import labSolution.Main
import org.scalatest.{FlatSpec, Matchers}

class ScalaTest extends FlatSpec with Matchers {
  it should "Test first task" in {
    Main.calcS(2, "20m") should be(2400.0)
  }

  it should "Test second task" in {
    Main.switchMethod(new Main.Feather) should be("Feather is dousing.")
  }
}
