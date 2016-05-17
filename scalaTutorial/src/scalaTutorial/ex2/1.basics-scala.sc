package scalaTutorial.ex2

object basicsScala {
	// 참조 강좌 https://www.youtube.com/watch?v=e3LHVMzNdLI&list=PLdzsTnb5Eq9-9--cYrpkoVbtJ-oKcGOlw

	/*
		개발 환경 셋팅
		mac
		http://brew.sh
		
		window
		http://scala-lang.org/download/
		
		
		환경변수
		Path 에 C:\Program Files (x86)\scala\bin 추가
		
		이후 cmd
		
		scala 치면 들어가짐
	*/

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  1 + 1                                           //> res0: Int(2) = 2
  
  // variable
  // imutable final String name = "Dave"
  val name: String = "Dave"                       //> name  : String = Dave
  val surname = "Really?"                         //> surname  : String = Really?
  
  // mutable variables
  var mutable1: Int = 2                           //> mutable1  : Int = 2
  mutable1 = 3
  
  val character: Char = 'c'                       //> character  : Char = c
  
  val aLongString: String = """A verry long string
  	that spans multiple lines
  	muhahahah
  """                                             //> aLongString  : String = "A verry long string
                                                  //|   	that spans multiple lines
                                                  //|   	muhahahah
                                                  //|   "
  
}