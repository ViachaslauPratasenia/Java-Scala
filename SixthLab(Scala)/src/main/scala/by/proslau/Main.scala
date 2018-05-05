package by.proslau

import scala.collection.mutable

object Main {

  def elemSum(first : mutable.MutableList[Int], second : mutable.MutableList[Int]): mutable.MutableList[Int] = {
    val buffer = first.clone()
    if(first.size >= second.size){
      for(i <- 0 to first.size - 1){
        if(i <= second.size - 1)
          first(i) = buffer(i) + second(i)
      }
    }
    else{
      for(i <- 0 to second.size - 1){
        if(i <= first.size - 1){
          first(i) = buffer(i) + second(i)
        }
        else first += second(i)
      }
    }
    first
  }

  def elemDiff(first : mutable.MutableList[Int], second : mutable.MutableList[Int]): mutable.MutableList[Int] = {
    val buffer = second.clone()
    if(first.size >= second.size){
      for(i <- 0 to first.size - 1){
        if(i <= second.size - 1) {
          second(i) = first(i) - buffer(i)
        }
        else second += first(i)
      }
    }
    else{
      for(i <- 0 to second.size - 1){
        if(i <= first.size - 1){
          second(i) = buffer(i) - first(i)
        }
        else second(i) = -second(i)
      }
    }
    second
  }

  def conc(list: List[List[Int]]): List[Int] = {
    list.fold(List[Int]())(_ ::: _)
  }

  def checkInt(list: List[Any]):List[Any] = {
    list.filter(s => {s.isInstanceOf[String]})
  }
}
