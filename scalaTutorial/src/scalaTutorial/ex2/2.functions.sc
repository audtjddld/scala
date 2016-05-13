package scalaTutorial.ex2

object functions {
	  println("Welcome to the Scala worksheet")
                                                  //> Welcome to the Scala worksheet
	  
	  def threeMultiplyedBy(x: Int): Int = {
	  	3 * x
	  }                                       //> threeMultiplyedBy: (x: Int)Int
	  
	  threeMultiplyedBy(2)                    //> res0: Int = 6
	  
	  val result = threeMultiplyedBy(45)      //> result  : Int = 135
	  
	 def threeMultpliendWith(x: Int) = 3 * x  //> threeMultpliendWith: (x: Int)Int
	 
	 def justSaying = "Hello world"           //> justSaying: => String
	 
	 justSaying                               //> res1: String = Hello world
	 
	 def sayingHello {
	   println("inside the method")
	   "Hi there!"
	 }                                        //> sayingHello: => Unit
	 
	 
	 
	 sayingHello                              //> inside the method
	 
	 (x:  Int) => x + 1                       //> res2: Int => Int = <function1>
	 
	 
	 val theFunction = (x: Int) => {x + 1}    //> theFunction  : Int => Int = <function1>
	 
	 theFunction.apply(3)                     //> res3: Int = 4
	 theFunction(3)                           //> res4: Int = 4
	 
	 def multiplication(x: Int = 2, y: Int = 1) = {
	  println("x:" + x + "y:" + y)
	  x + y
	 }                                        //> multiplication: (x: Int, y: Int)Int
	 
	 multiplication(3, 4)                     //> x:3y:4
                                                  //| res5: Int = 7
	multiplication()                          //> x:2y:1
                                                  //| res6: Int = 3
	multiplication(1)                         //> x:1y:1
                                                  //| res7: Int = 2
// varied length arguments
 def showAll(theArgs: Int*) = {
   theArgs.foreach(println)
 }                                                //> showAll: (theArgs: Int*)Unit
 
 showAll(1,3,4,4)                                 //> 1
                                                  //| 3
                                                  //| 4
                                                  //| 4
 showAll(1,2)                                     //> 1
                                                  //| 2
                                                  
  // 인자값을 저렇게 데이터 타입을 셋팅해 줘야 됨
	def multiply(x: Int, y: Int) = {
		x * y
	}                                         //> multiply: (x: Int, y: Int)Int
	
	val timesTwo = multiply(2, _:Int)         //> timesTwo  : Int => Int = <function1>
	
	timesTwo(3)                               //> res8: Int = 6
	timesTwo(4)                               //> res9: Int = 8
	
	
	// def functionName(parameter):returnType 형태로 정의 됨
	
	def theMultiplication(x:Int)(y:Int):Int = {
		x * y
	}                                         //> theMultiplication: (x: Int)(y: Int)Int
	
	theMultiplication(2)(3)                   //> res10: Int = 6
	
	// 파라미터 한쪽 정의 후 나머지 부분만 전달 받기
	val aMultiplication = theMultiplication(2)_
                                                  //> aMultiplication  : Int => Int = <function1>
	
	// do something
	aMultiplication(3)                        //> res11: Int = 6
}