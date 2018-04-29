package mPackage

import scala.annotation.tailrec
import scala.collection.mutable

object objectLab{
  def main(args: Array[String]): Unit = {
    val list = List[Int](1,2,3,4,5,6,7,8)
    val list1 = mutable.MutableList[Int](1, 2, 0, 0, -3)
    val list2 = mutable.MutableList[Int]()
  }

  def sumRecursive(list: List[Int],size: Int): Int = {
    if(size > 0) list(size - 1) + sumRecursive(list, size - 1)
    else 0
  }

  def sumTailRecursive(list: List[Int]): Int = {
    @tailrec
    def sumIter(list: List[Int], acc:Int, index:Int):Int={
      if(index < list.length) sumIter(list, list(index) + acc, index+1)
      else acc
    }
    sumIter(list, 0, 0)
  }

  def bigNumNotRec(oldList: mutable.MutableList[Int], newList: mutable.MutableList[Int]): mutable.MutableList[Int] = {
    for(i <- 2 to oldList.size - 1){
      if(oldList(i) < Math.abs(oldList(i - 1) - oldList(i - 2))) newList += oldList(i)
    }
    newList
  }

  def sumList(list: mutable.MutableList[Int]): mutable.MutableList[Int] = {
    val sum = list.reduceLeft(_ + _)
    list.filter((i:Int) => i % 1 == 0)
    list += sum
    list
  }

  def bigNumTail(oldList: mutable.MutableList[Int]): mutable.MutableList[Int] = {
    @tailrec
    def find(oldList: mutable.MutableList[Int], newList: mutable.MutableList[Int], index: Int): mutable.MutableList[Int] = {
      if (index < oldList.size) {
        isValueTrueAdd(newList, oldList(index - 1), oldList(index), oldList(index - 2))
        find(oldList, newList, index + 1)
      }
      else {
        newList
      }
    }
    def isValueTrueAdd(newList: mutable.MutableList[Int], valuePrev: Int, value: Int, valuePrevPrev: Int): Unit = {
      if (Math.abs(valuePrev - valuePrevPrev) > value) {
        newList += value
      }
    }
    if (oldList.size > 2) {
      find(oldList, mutable.MutableList(), 2)
    }
    else {
      mutable.MutableList()
    }
  }
}