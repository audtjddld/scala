package scalaTutorial.ex2

object DataType {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  /*
		기본 데이터 구조
		리스트
		집합
		튜플
		맵
		함수 콤비네이터(Functional Combinator)
		map
		foreach
		filter
		zip
		partition
		find
		drop과 dropWhile
		foldRight과 foldLeft
		flatten
		flatMap
		일반적인 함수 콤비네이터
		Map?
		기본 데이
  */

  // 리스트
  val numbers = List(1, 2, 3, 4)                  //> numbers  : List[Int] = List(1, 2, 3, 4)

  // 집합
  // 집합에는 중복된 원소가 들어갈 수 없다.
  Set(1, 1, 2)                                    //> res0: scala.collection.immutable.Set[Int] = Set(1, 2)

  // 튜플
  // 클래스를 정의하지 않고도 여러 아이템을 쉽게 한데 묶을 수 있다.
  val hostPort = ("localhost", 80)                //> hostPort  : (String, Int) = (localhost,80)

  // 케이스 클래스와 달리 튜플의 억세서(accessor)에는 이름이 없다. 대신 위치에 따라 숫자로 된 억세서가 있다. 첫번째 원소는 0번이 아니고 1번이다(역주: 1번부터 시작한 것은 함수언어의 전통에 따른 것이다).

  hostPort._1                                     //> res1: String = localhost

  hostPort._2                                     //> res2: Int = 80

  // 튜플은 패턴 매칭과 잘 들어 맞는다.
  /*
	hostPort match (
		case ("localhost", port) => println(String, Int)
		case (host, port) = (1,2)
	)
	*/
  // 두 값을 묶는 튜플을 만드는 특별한 소스로 -> 가 있다.
  1 -> 2                                          //> res3: (Int, Int) = (1,2)

  // 맵
  // 맵에 기본적인 데이터타입을 담을 수 있다.
  Map(1 -> 2)                                     //> res4: scala.collection.immutable.Map[Int,Int] = Map(1 -> 2)
  Map("foo" -> "bar")                             //> res5: scala.collection.immutable.Map[String,String] = Map(foo -> bar)
  // ->는 맵을 위한 특별한 문법처럼 보이지만, ->는 단지 튜플을 만들기 위한 것이다.
  // 또한 위 Map()에는 1강에서 살펴 본 가변 길이 인자 문법이 사용되었다. 따라서 Map( 1-> "one", 2-> "two")은 실제로는 Map((1, "one"), (2, "two"))가 되고,
  // 리스트에 있는 각 튜플의 첫번째 원소는 키, 두번째 원소는 값이 된다.
  // 맵이 다른 맵이나 함수를 값으로 보관할 수도 있다.

  Map(1 -> Map("foo" -> "bar"))                   //> res6: scala.collection.immutable.Map[Int,scala.collection.immutable.Map[Str
                                                  //| ing,String]] = Map(1 -> Map(foo -> bar))
  //Map("timesTwo" -> { timesTwo(_) })

  // 옵션
  /*
		어떤 것(객체)가 존재하거나 존재하지 않을 수 있을 때, Option을 사용해 처리한다.
		
		옵션의 기본 인터페이스는 다음과 같다.
		
		trait Option[T] { def isDefined: Boolean def get: T def getOrElse(t: T): T }
		
		옵션 자체는 일반적 클래스이며, 두 하위클래스 Some[T]와 None이 있다.
		
		이제 옵션을 어떻게 사용하는지 살펴보자.
		
		Map.get은 Option를 반환한다. 옵션을 반환한다는 것은 찾는 값이 없을 수도 있다는 의미이다.
	*/

  val numbersMap = Map("one" -> 1, "two" -> 2)    //> numbersMap  : scala.collection.immutable.Map[String,Int] = Map(one -> 1, tw
                                                  //| o -> 2)

  numbersMap.get("two")                           //> res7: Option[Int] = Some(2)

  numbersMap.get("three")                         //> res8: Option[Int] = None

  /*
		이제 데이터가 Option에 들어가 있을 것이다. 그럼 그 옵션을 가지고는 무얼 할 수 있을까?
		
		아마도 isDefined 메소드를 사용해 조건부 처리를 하는 것이 가장 먼저 반사적으로 떠오를 것이다.
		
		// 수에 2를 곱하자. 만약 값이 없으면 0을 반환하자. val result = if (res1.isDefined) { res1.get * 2 } else { 0 }
		
		하지만 그보다는 getOrElse나 패턴 매칭을 사용할 것을 권한다.
		
		getOrElse을 사용하면 기본 값을 쉽게 지정할 수 있다.
		
		val result = res1.getOrElse(0) * 2
		
		패턴 매칭도 자연스럽게 Option과 맞아들어간다.
		
		val result = res1 match { case Some(n) => n * 2 case None => 0 }
		
		See Also 효율적인 스칼라를 보면 옵션에 대한 글이 있다.
	*/

  // map
  // 리스트의 모든 원소에 함수를 적용한 결과값으로 이루어진 새 리스트를 반환한다. 원소 갯수는 적용 되상이 된 리스트의 원소 갯수와 동일하다.
  numbers.map((i: Int) => i * 2)                  //> res9: List[Int] = List(2, 4, 6, 8)

  // 또는 부분 적용된 함수를 넘길 수도 있다.
  def timesTwo(i: Int): Int = i * 2               //> timesTwo: (i: Int)Int

  numbers.map(timesTwo _)                         //> res10: List[Int] = List(2, 4, 6, 8)

  // foreach
  // foreach는 맵과 비슷하지만, 반환하는 것이 없다. 따라서 foreach는 부작용(값을 반환하는 것이 아니고 상태를 변화시키는 것)을 위해 사용한다. (값만 변화)

  numbers.foreach((i: Int) => i * 2)

  // 위 코드는 아무 것도 반환하지 않는다.
  // 반환되는 값을 변수에 넣을 수도 있다. 하지만, 그 타입은 Unit(즉, void)이다.

  val doubled = numbers.foreach((i: Int) => i * 2)//> doubled  : Unit = ()
  // filter
  // 전달된 함수가 거짓을 반환하는 원소들을 제외한 나머지 원소들로 이루어진 리스트를 반환한다. 참/거짓(즉, Boolean 값)을 반환하는 함수를 술어함수(predicate function)라 부르곤 한다.

  numbers.filter((i: Int) => i % 2 == 0)          //> res11: List[Int] = List(2, 4)

  def isEven(i: Int): Boolean = i % 2 == 0        //> isEven: (i: Int)Boolean

  numbers.filter(isEven _)                        //> res12: List[Int] = List(2, 4)

  // zip
  // zip은 두 리스트의 원소들의 쌍(튜플)으로 이루어진 단일 리스트를 반환한다.
  List(1, 2, 3).zip(List("a", "b", "c"))          //> res13: List[(Int, String)] = List((1,a), (2,b), (3,c))
  
  
  // partition
  // 술어 함수가 반환하는 값에 따라 리스트를 둘로 나눈다.
  // (역주, 원래 리스트의 모든 원소는 반환되는 두 리스트 중 어느 하나에 꼭 포함되며, 한 원소가 양쪽에 같이 속하는 일도 없다.)
  
  val numbersList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                                                  //> numbersList  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  numbersList.partition(_ % 2 == 0)               //> res14: (List[Int], List[Int]) = (List(2, 4, 6, 8, 10),List(1, 3, 5, 7, 9))
                                                  //| 
  
 // find
 // find는 리스트에서 술어함수를 만족하는 가장 첫 원소를 반환한다.
 
 numbersList.find((i: Int) => i > 5)              //> res15: Option[Int] = Some(6)
 
 // drop과 dropWhile
 // drop은 첫 i개의 원소를 떨군다. 따라서 나머지 (원래 리스트 길이-i)개의 원소만 남는다.
 numbersList.drop(5)                              //> res16: List[Int] = List(6, 7, 8, 9, 10)
 
 /*
	dropWhile은 리스트의 앞에서 술어함수를 만족하는 원소를 없앤다. 술어함수가 최초로 거짓을 반환하면 그 뒤의 원소들은 살아 남는다.
	예를 들어 numbers 리스트에서 홀수를 dropWhile하면 1이 떨어져 나간다. (하지만 3은 2가 "방패막이"가 되기 때문에 결과 리스트에 들어간다).
 */
 numbers.dropWhile(_ % 2 != 0)                    //> res17: List[Int] = List(2, 3, 4)
 
 // foldLeft
 /*
	0은 시작 값이고(numbers가 List[Int]라는 사실을 기억하라), m은 값을 누적하는 변수 역할을 한다.
	
	(역주: 여기서 누적이란 말은 덧셈으로 합산된다는 의미가 아니다. 물론 본 예제에서는 합산이 되고 있지만, 앞의 원소에 함수를 적용한 결과값이 전달되는 위치가 m이라는 의미이다. 풀어쓰자면, List(a1,a2,…,an).foldLeft(v0)(f)는 f(…f(f(v0,a1),a2),an)이다.)
	
	foldLeft의 작동 과정을 자세히 보면 다음과 같다.
 */
 
 
}