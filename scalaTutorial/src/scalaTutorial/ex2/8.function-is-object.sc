package scalaTutorial.ex2

object FunctionIsObject {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  class AddOne extends Function1[Int, Int] {
    def apply(m: Int): Int = m + 1
  }

  val addOne = new AddOne                         //> addOne  : scalaTutorial.ex2.FunctionIsObject.AddOne = <function1>

  addOne(1)                                       //> res0: Int = 2

  /*
 		그렇다면 클래스의 메소드를 정의할 때마다 실제로 Function*의 인스턴스가 만들어지는 걸까?
 		아니다. 클래스 내부의 메소드는 메소드이다. repl(read eval print loop. 입력을 받아 값을 계산하고 결과를 출력하는 루프. 스칼라 인터프리터라 생각하면 대략 맞다)에서 정의한 개별 메소드는 Function*의 인스턴스이다.
	*/
	
	class AddOne2 extends (Int => Int) {
	 def apply(m: Int): Int = m + 1
	}
	
	val addOne2 = new AddOne2                 //> addOne2  : scalaTutorial.ex2.FunctionIsObject.AddOne2 = <function1>
	addOne2(1)                                //> res1: Int = 2
	
	// 패턴 매칭
	/*
		패턴 매치는 스칼라에서 가장 유용한 기능 중 하나이다.
		
		값에 대해 매칭할 수 있다.
	*/
	
	val times = 1                             //> times  : Int = 1
	times match {
	  case 1 => "one"
	  case 2 => "two"
	  case _ => "some other number"
	}                                         //> res2: String = one
	
	/*
	val times = 0.0
	
	times match {
	 	case i: Int if i < 0 => i - 1
	 	case i: Int => i + 1
	 	case d: Double if d < 0.0 => d - 0.1
	 	case d: Double => d + 0.1
	 	case text: String => text + "s"
	}
	*/
	
	
}