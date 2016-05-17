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

  val bar = new Bar                               //> bar  : scalaTutorial.ex2.applymethod.Bar = scalaTutorial.ex2.applymethod$$an
                                                  //| onfun$main$1$Bar$1@6e8dacdf

  bar()                                           //> res0: Int = 0

  // apply를 정의하면 메소드를 호출하듯 객체 인스턴스를 호출 할 수 있다.
  // 객체 인스턴스를 호출하면 그 객체(클래스)에 정의된 apply()가 호출된다.

  // 클래스와 객체가 같은 이름을 가질 수도 있다. 이런 객체를 '짝 객체(companion Object)'라 한다.
  // 보통 팩토리를 만들 때 짝 객체를 사용한다.

  class Calculator {
    var brand = ""
    var model = ""
  }

  // 클래스 맴버에 대해 매치시키기
  // 앞에서 봤던 계산기 예제를 다시 떠올려보자.
  // 타입 ( 계산기의 유형) 에 따라 계산기를 구분하자.

  def calcType(calc: Calculator) = calc match {
    case _ if calc.brand == "hp" && calc.model == "20B" => "financial"
    case _ if calc.brand == "hp" && calc.model == "48G" => "scientific"
    case _ if calc.brand == "hp" && calc.model == "30B" => "business"
    case _ => "unknown"
  }                                               //> calcType: (calc: scalaTutorial.ex2.applymethod.Calculator)String

  // 케이스 클래스 ( case class )
  // 케이스 클래스는 손쉽게 내용을 어떤 클래스에 저장하고, 드에 따라 매치를 하고 싶은 경우 사용한다. new를 사용하지 않고도 케이스 클래스의 인스턴스를 생성이 가능하다.

  case class Calculators(brand: String, model: String)

  val hp20b = Calculators("hp", "20b")            //> hp20b  : scalaTutorial.ex2.applymethod.Calculators = Calculators(hp,20b)

  // 케이스 클래스는 자동으로 생성자 인자에 따른 동등성 검사를 제공하며, 또한 보기 좋은 toString 메소드도 제공한다.
  val hp20B = Calculators("hp", "20b")            //> hp20B  : scalaTutorial.ex2.applymethod.Calculators = Calculators(hp,20b)

  hp20b == hp20B                                  //> res1: Boolean = true

  // 케이스 클래스 안에도 일반 클래스와 똑같이 메소드를 정의할 수 있다.
  /*
		케이스 클래스와 패턴 매칭
		케이스 클래스는 패턴 매치와 사용하기 위해 설계된 것이다. 앞의 계산기 분류 예제를 간략하게 만들어보자.
	*/
  val hp20c = Calculators("hp", "20C")            //> hp20c  : scalaTutorial.ex2.applymethod.Calculators = Calculators(hp,20C)
  val hp30c = Calculators("hp", "30C")            //> hp30c  : scalaTutorial.ex2.applymethod.Calculators = Calculators(hp,30C)

  def calcTypes(calc: Calculators) = calc match {
    case Calculators("hp", "20C")        => "financial"
    case Calculators("hp", "48G")        => "scientific"
    case Calculators("hp", "30B")        => "business"
    case Calculators(ourBrand, ourModel) => "Calculators : %s %s is of unknown type".format(ourBrand, ourModel)
  }                                               //> calcTypes: (calc: scalaTutorial.ex2.applymethod.Calculators)String

	calcTypes(hp20c)                          //> res2: String = financial
	
  /*
		마지막 매치는 다음과 같이 쓸 수도 있다.
		
		  case Calculator(_, _) => "Calculator of unknown type"
		혹은, 그냥 calc가 계산기인지 아닌지도 명시하지 않아도 된다.
		
		  case _ => "Calculator of unknown type"
		아니면, 매치된 값에 다른 이름을 붙일 수도 있다.
		
		  case c@Calculator(_, _) => "Calculator: %s of unknown type".format(c)
	*/

  /*
	예외
   	스칼라에서는 예외 처리시 tray-catch-finally 문법에 패턴 매치를 사용할 수 있다.
  try {
    remoteCalculatorService.add(1, 2)
  } catch {
    case e: ServerIsDownException => log.error(e, "the remote calculator service is unavailble. should have kept your trustry HP.")
  } finally {
    remoteCalculatorService.close()
  }
*/

}

// 객체
// 객체(여기서는 object 키워드로 선언하는 객체를 말함)는 클래스의 유일한 인스턴스를 넣기 위해 사용한다. 보통 팩토리에 사용된다.

object Timer {
  var count = 0

  def currentCount(): Long = {
    count += 1
    count
  }

  // 패턴 매칭
  // 패턴 매치는 스칼라에서 가장 유용한 기능 중 하나이다.
  // 값에 대해 매칭할 수 있다.

  var times = 1
  times match {
    case 1 => "one"
    case 2 => "two"
    case _ => "some other number"
  }
  // 가드(조건문)를 사용해 매칭할 수 있다.
  times match {
    case i if i == 1 => "one"
    case i if i == 2 => "two"
    case _           => "some other number"
  }

  /*
		변수 ’i’에 어떻게 값을 잡아 넣었는지 주의깊게 살펴보라.
		
		마지막 경우의 _는 와일드카드이다. 즉, 모든 경우를 처리한다. 만약 이 부분이 없다면 매치되지 않는 값이 들어온 경우 런타임 에러가 발생할 것이다. 이에 대해서는 나중에 살펴보겠다.
		
		See Also 효율적인 스칼라에서 패턴매치를 사용해야 하는 경우와 패턴 매칭을 어떤 형식으로 할지에 대해 설명한다. 스칼라 여행에서도 패턴매칭을 다룬다
	*/

  // 타입에 대해 매치시키기
  // match를 사용해 타입이 다른 값을 서로 다른 방식으로 처리 가능하다.
  def bigger(o: Any): Any = {
    o match {
      case i: Int if i < 0      => i - 1
      case i: Int               => i + 1
      case d: Double if d < 0.0 => d - 0.1
      case d: Double            => d + 0.1
      case text: String         => text + "s"
    }
  }
}