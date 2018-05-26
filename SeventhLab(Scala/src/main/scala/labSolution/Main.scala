package labSolution

/*
Реализовать  функцию  calcS(v:  Float,  t:  String):  Float,  возвращающую  пройденное расстояние 'S'
за время 't' со скоростью в метрах в секунду 'v'. Параметр функции 't' представляет  из  себя  строку  с  записью
времени  в  секундах  ("3600s"),  минутах ("50m") или часах ("1h").
 */

object Main {
  def calcS (speed : Float, parameter : String) : Float = {
    parameter.charAt(parameter.length() - 1) match {
      case 's' => parameter.substring(0, parameter.length() - 1).toInt * speed
      case 'm' => parameter.substring(0, parameter.length() - 1).toInt * speed * 60
      case 'h' => parameter.substring(0, parameter.length() - 1).toInt * speed * 3600
    }
  }

  class Feather() {
    def douse() : String = "Feather is dousing."
  }

  class Pen() {
    def removeCap() : String = "Removing the pen's cap."
  }

  class Pencil() {
    def sharpen() : String = "Pencil is sharpening."
  }

  def switchMethod(value : AnyRef) : String = {
    value match {
      case obj : Feather => obj.douse()
      case obj : Pen => obj.removeCap()
      case obj : Pencil => obj.sharpen()
      case _ => "Unknown object."
    }
  }
}
