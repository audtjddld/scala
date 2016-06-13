package scalaTutorial.ex2

object collection {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // 리스트
  val numbers = List(1, 2, 3, 4)                  //> numbers  : List[Int] = List(1, 2, 3, 4)
  
  
  // 집합
  Set(1, 1, 2)                                    //> res0: scala.collection.immutable.Set[Int] = Set(1, 2)
  
  // 튜플
  // 튜플을 사용하면 클래스를 정의하지 않고도 여러 아이템을 쉽게 한데 묶을 수 있다.
  val hostPort = ("localhost", 80)                //> hostPort  : (String, Int) = (localhost,80)
  
  hostPort._1                                     //> res1: String = localhost
  
  hostPort._2                                     //> res2: Int = 80
  
  // 튜플은 패턴 매칭과 잘 들어맞는다.
  
  hostPort match {
  	case ("localhost", port) => "1"
  	case (host, port) =>	"2"
  }                                               //> res3: String = 1
  
  // 두 값을 묶는 튜플을 만드는 특별한 소스로 ->가 있다.
  1 -> 2                                          //> res4: (Int, Int) = (1,2)
  
  val tu = 1 -> 2                                 //> tu  : (Int, Int) = (1,2)
  
  // 맵
  Map(1 -> 2)                                     //> res5: scala.collection.immutable.Map[Int,Int] = Map(1 -> 2)
  Map("foo" -> "bar")                             //> res6: scala.collection.immutable.Map[String,String] = Map(foo -> bar)
  /*
		위 코드에서 ->는 맵을 위한 특별한 문법처럼 보인다. 하지만, 튜플에서 본 것처럼 ->는 단지 2-튜플을 만들기 위한 것이다.
		또한 위 Map()에는 1강에서 살펴 본 가변 길이 인자 문법이 사용되었다. 따라서 Map(1 -> "one", 2 -> "two")은 실제로는 Map((1, "one"), (2, "two"))가 되고, 리스트에 있는 각 튜플의 첫번째 원소는 키, 두번째 원소는 값이 된다.
		맵이 다른 맵이나 함수를 값으로 보관할 수도 있다.
  */
  Map(1 -> Map("foo" -> "bar"))                   //> res7: scala.collection.immutable.Map[Int,scala.collection.immutable.Map[Stri
                                                  //| ng,String]] = Map(1 -> Map(foo -> bar))
                                                  
	// 옵션
	/*
		어떤 것(객체)가 존재하거나 존재하지 않을 수 있을 때, Option을 사용해 처리한다.
		옵션의 기본 인터페이스는 다음과 같다.
		trait Option[T] { def isDefined: Boolean def get: T def getOrElse(t: T): T }
		옵션 자체는 일반적 클래스이며, 두 하위클래스 Some[T]와 None이 있다.
		이제 옵션을 어떻게 사용하는지 살펴보자.
		Map.get은 Option를 반환한다. 옵션을 반환한다는 것은 찾는 값이 없을 수도 있다는 의미이다.
	*/
	val numbers2 = Map("one" -> 1, "two" -> 2)//> numbers2  : scala.collection.immutable.Map[String,Int] = Map(one -> 1, two 
                                                  //| -> 2)
	
	numbers2.get("two")                       //> res8: Option[Int] = Some(2)
	
	numbers2.get("three")                     //> res9: Option[Int] = None
	
	 // 함수 콤비네이터
	 /*
		(역주: 콤비네이터란 이름에 웬지 모를 위압감을 느낄지도 모르겠는데, 콤비네이터는 함수와 컬렉션 등 다른 식을 받아서 적절한 작업을 해주는 조합 장치(함수) 정도로 생각하면 된다.)
		List(1, 2, 3) map squared라고 하면 squared 함수를 리스트의 모든 원소에 적용한 다음 새 리스트를 반환한다. 결과는 아마도 List(1, 4, 9)가 될 것이다.
		map과 같은 함수를 콤비네이터(combinator)라 부른다. (더 나은 정의를 보고픈 사람은 스택 오버플로우의 콤비네이터에 대한 설명을 참조하라.) 콤비네이터는 보통 표준 데이터 구조에 많이 사용된다.
	 */
	 
	 numbers.map((i: Int) => i * 2)           //> res10: List[Int] = List(2, 4, 6, 8)
	 
	 def timesTwo(i: Int): Int = i * 2        //> timesTwo: (i: Int)Int
	 
	 numbers.map(timesTwo _)                  //> res11: List[Int] = List(2, 4, 6, 8)
	 
	 
	 // foreach
	 
	 numbers.foreach((i: Int) => i * 2)
	 // 위 코드는 아무것도 반환하지 않는다.
	 // 반환되는 값을 변수에 넣을 수도 있다. 그 타입은 Unit(즉, void)이다.
	 val doubled = numbers.foreach((i: Int) => i * 2)
                                                  //> doubled  : Unit = ()
                                                  
	// filter
	// 전달된 함수가 거짓을 반환하는 원소들을 제외한 나머지 원소들로 이루어진 리스트를 반환한다. 참/거짓(즉, Boolean 값)을 반환하는 함수를 술어함수(predicate function)라 부르곤 한다.
	
	numbers.filter((i: Int) => i % 2 == 0 )   //> res12: List[Int] = List(2, 4)
	
	def isEven(i: Int): Boolean = i % 2 == 0  //> isEven: (i: Int)Boolean
	
	numbers.filter(isEven _)                  //> res13: List[Int] = List(2, 4)
	
	// zip
	// zip은 두 리스트의 원소들의 쌍(튜플)으로 이루어진 단일 리스트를 반환한다.
	List(1, 2, 3).zip(List("a", "b", "c"))    //> res14: List[(Int, String)] = List((1,a), (2,b), (3,c))
	
	// partition
	/*
		partition은 술어 함수가 반환하는 값에 따라 리스트를 둘로 나눈다.
		(역주. 원래 리스트의 모든 원소는 반환되는 두 리스트 중 어느 하나에 꼭 포함되며, 한 원소가 양쪽에 같이 속하는 일도 없다.)
	*/
	val numbers3 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                                                  //> numbers3  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
	numbers3.partition(_ % 2 == 0)            //> res15: (List[Int], List[Int]) = (List(2, 4, 6, 8, 10),List(1, 3, 5, 7, 9))
                                                  //| 
                                                  
	// find
	// find는 리스트에서 술어함수를 만족하는 가장 첫 원소를 반환한다.
	numbers3.find((i: Int) => i > 5)          //> res16: Option[Int] = Some(6)
	
	// drop
	// drop은 첫 i개의 원소를 떨군다. 따라서 나머지 (원래 리스트 길이-i)개의 원소만 남는다.
	numbers3.drop(5)                          //> res17: List[Int] = List(6, 7, 8, 9, 10)
	// dropWhile
	/*
		dropWhile은 리스트의 앞에서 술어함수를 만족하는 원소를 없앤다. 술어함수가 최초로 거짓을 반환하면 그 뒤의 원소들은 살아 남는다.
		예를 들어 numbers 리스트에서 홀수를 dropWhile하면 1이 떨어져 나간다. (하지만 3은 2가 "방패막이"가 되기 때문에 결과 리스트에 들어간다).
	*/
	numbers3.dropWhile(_ % 2 != 0)            //> res18: List[Int] = List(2, 3, 4, 5, 6, 7, 8, 9, 10)
}