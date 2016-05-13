package scalaTutorial.ex2

object variableLengthArguments {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def showAll(theArgs: Int*) = {
   theArgs.foreach((a:Int) => println(a))
  }                                               //> showAll: (theArgs: Int*)Unit
  
  
  showAll(1,2,3,4,5,6)                            //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
  
  showAll(2,3,5)                                  //> 2
                                                  //| 3
                                                  //| 5
}