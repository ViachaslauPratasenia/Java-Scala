package test.scala
import mPackage.objectLab
import org.scalatest._

import scala.collection.mutable

class ExampleSpec extends FlatSpec with Matchers {

  it should "sum elements of list" in {
    val list = List[Int](1,2,3)
    (1 to list.length).reduceLeft(_ + _) should be (6)
  }

  it should "sum elements of list recursive" in {
    val list = List[Int](1,2,3)
    objectLab.sumRecursive(list, list.length) should be(6)
    objectLab.sumTailRecursive(list) should be (6)
  }

  it should "sum elements of list tail recursive" in {
    val list = List[Int](1,2,3)
    objectLab.sumTailRecursive(list) should be (6)
  }

  it should "Fing num tail recursive" in {
    val list = mutable.MutableList[Int](1, 2, 0, 0, -3)
    val newList = mutable.MutableList[Int]()
    val ans = mutable.MutableList[Int](0,0,-3)
    objectLab.bigNumNotRec(list, newList)
    for(i <- 0 to ans.size - 1){
      assert(newList(i) === ans(i))
    }
  }
}
