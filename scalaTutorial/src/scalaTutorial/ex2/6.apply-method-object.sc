package scalaTutorial.ex2

// https://twitter.github.io/scala_school/ko/basics2.html
object applymethod {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  // apply 메소드를 사용하면 클래스나 객체의 용도가 주로 하나만 있는 경우를 아주 멋지게 표현할 수 있다.
  
  class Foo {}
	
//	defined class Foo
	
	object FooMaker {
	 def apply() = new Foo
	}
  
//  defined module FooMaker
  
  val newFoo = FooMaker()                         //> newFoo  : scalaTutorial.ex2.applymethod.Foo = scalaTutorial.ex2.applymethod$
                                                  //| $anonfun$main$1$Foo$1@1e643faf
                                                  
 // 다음과 같이도 쓸 수 있다.
 
 class Bar {
 	def apply() = 0
 }
 
 val bar = new Bar                                //> bar  : scalaTutorial.ex2.applymethod.Bar = scalaTutorial.ex2.applymethod$$an
                                                  //| onfun$main$1$Bar$1@6e8dacdf
 
 bar()                                            //> res0: Int = 0
 
 // apply를 정의하면 메소드를 호출하듯 객체 인스턴스를 호출 할 수 있다.
 // 객체 인스턴스를 호출하면 그 객체(클래스)에 정의된 apply()가 호출된다.
 
  // 클래스와 객체가 같은 이름을 가질 수도 있다. 이런 객체를 '짝 객체(companion Object)'라 한다.
 // 보통 팩토리를 만들 때 짝 객체를 사용한다.

}

 
 
 // 객체
 // 객체(여기서는 object 키워드로 선언하는 객체를 말함)는 클래스의 유일한 인스턴스를 넣기 위해 사용한다. 보통 팩토리에 사용된다.

object Timer {
 var count  = 0
 
 def currentCount(): Long = {
  count += 1
  count
 }

}