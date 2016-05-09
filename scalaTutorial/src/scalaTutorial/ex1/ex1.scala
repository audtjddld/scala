package scalaTutorial.ex1

import scala.io.StdIn.readLine

object ex1 {
  def main(args: Array[String]): Unit = {
    var numberGuess = 0
    do {
      print("Guess a number " )
      numberGuess = readLine.toInt
      
    } while(numberGuess != 15)
      
      printf("You guessed the secret nuber %d\n", 15)
  }
}