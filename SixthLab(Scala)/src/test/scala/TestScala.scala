package test.scala
import by.proslau.Main
import org.scalatest._

import scala.collection.mutable

class ExampleSpec extends FlatSpec with Matchers {
  it should "Element's sum of 2 lists" in {
    val firstList = mutable.MutableList[Int](1,2,3)
    val secondList = mutable.MutableList[Int](1,2,3,4,5)
    val answer = mutable.MutableList[Int](2,4,6,4,5)
    Main.elemSum(firstList, secondList)
    for(i <- 0 to answer.size - 1){
      assert(firstList(i) === answer(i))
    }
  }

  it should "Element's difference of 2 lists" in {
    val firstList = mutable.MutableList[Int](1,2,3)
    val secondList = mutable.MutableList[Int](1,2,3,4,5)
    val answer = mutable.MutableList[Int](0,0,0,-4,-5)
    Main.elemDiff(firstList, secondList)
    for(i <- 0 to answer.size - 1){
      assert(secondList(i) === answer(i))
    }
  }

  it should "Flatten of lists" in{
    val list = List[List[Int]](List[Int](1,2), List[Int](3,4), List[Int](5,6))
    val answer = List[Int](1,2,3,4,5,6)
    assert(Main.conc(list) == answer)
  }

  it should "Check Int" in {
    val list = List[Any]("One", 2, 3, "Four")
    val ans = List[Any]("One", "Four")
    assert(Main.checkInt(list) == ans)
  }
}
