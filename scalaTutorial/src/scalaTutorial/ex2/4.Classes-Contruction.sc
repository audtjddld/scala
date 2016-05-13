package scalaTutorial.ex2

import scala.beans.BeanProperty

object ClassesContruction {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  class Duck

  class MallardDuck(val name: String,
                    var nickName: String) {
    println("Inside the contructor")
    var color: String = if (name == "Ducky") "red"
    else if (name == "Iffy") "pink"
    else "yello"
    
    def canSing(aParam: String) = {
      if (aParam == "Ducky") "ICanSquuek"
      else if (aParam == "Iffy") "ICanQuak"
      else "mute"
    }
    
    def canFly = {
	      if (name == "Ducky") "ICanFly"
	      else if (name == "Iffy") "ICanQuak"
	      else "mute"
    }
    
    val anonim = {() => "A String: " + name}
    
    override def toString = "A duck by the name " + name + " and color " + color + " and nickName " + nickName;
  }

  val theDuck = new MallardDuck("Ducky", "Ducky the Duck")
                                                  //> Inside the contructor
                                                  //| theDuck  : scalaTutorial.ex2.ClassesContruction.MallardDuck = A duck by the 
                                                  //| name Ducky and color red and nickName Ducky the Duck

  println("color:" + theDuck.color)               //> color:red
  theDuck.color = "another"

  println("color after reassignment:" + theDuck.color)
                                                  //> color after reassignment:another
  println("name:" + theDuck.name)                 //> name:Ducky
  println("name:" + theDuck.nickName)             //> name:Ducky the Duck
  // val은 getter, setter가 없는 immutable 변수고
  // var는 getter, setter가 가능한 변수임
  
  println(theDuck.canSing("Ducky"))               //> ICanSquuek
  println(theDuck.canSing("Iffy"))                //> ICanQuak
  
  // 펑션에 파라미터가 없으면 이름만 써준다
  println(theDuck.canFly)                         //> ICanFly
  // 익명함수는 ()를 사용한다.
  println(theDuck.anonim())                       //> A String: Ducky
}