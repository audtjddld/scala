package scalaTutorial.ex2

object extend {
  // https://twitter.github.io/scala_school/ko/basics.html 예제

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  class Calculator(brand: String) {
    /**
     * 생성자
     */
    val color: String = if (brand == "TI") {
      "blue"
    } else if (brand == "HP") {
      "black"
    } else {
      "white"
    }

    // 인스턴스 메소드
    def add(m: Int, n: Int): Int = m + n
  }

  val calc = new Calculator("HP")                 //> calc  : scalaTutorial.ex2.extend.Calculator = scalaTutorial.ex2.extend$$anon
                                                  //| fun$main$1$Calculator$1@6a5fc7f7

  calc.color                                      //> res0: String = black
  // 상속
  class ScientificCalculator(brand: String) extends Calculator(brand) {
    def log(m: Double, base: Double) = math.log(m) / math.log(base)
  }
  // 메소드 중복정의(Overloading)
  class EvenMoreScientificCalculator(brand: String) extends ScientificCalculator(brand) {
    def log(m: Int): Double = log(m, math.exp(1))
  }

  // 추상 클래스
  abstract class Shape {
    def getArea(): Int
  }

  class Circle(r: Int) extends Shape {
    def getArea(): Int = { r * r * 3 }
  }
  // val s = new Shape
  // 추상 클래스는 인스턴스를 생성할 수 없다.

  val c = new Circle(2)                           //> c  : scalaTutorial.ex2.extend.Circle = scalaTutorial.ex2.extend$$anonfun$ma
                                                  //| in$1$Circle$1@880ec60
  c.getArea()                                     //> res1: Int = 12

  //트레잇(Traits, 특성이라는 뜻)
  //트레잇(trait)은 다른 클래스가 확장(즉, 상속)하거나 섞어 넣을 수 있는(이를 믹스인Mix in 이라 한다) 필드와 동작의 모음이다.

  trait Car {
    val brand: String
  }

  trait Shiny {
    val shineRefraction: Int
  }

  class BMW extends Car with Shiny{
    val brand = "BMW"
    val shineRefraction = 12
  }
  
  val bmw = new BMW                               //> bmw  : scalaTutorial.ex2.extend.BMW = scalaTutorial.ex2.extend$$anonfun$mai
                                                  //| n$1$BMW$1@3f3afe78
                                                  
	println(bmw.brand)                        //> BMW
	println(bmw.shineRefraction)              //> 12
}