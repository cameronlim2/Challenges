import scala.collection.mutable.ListBuffer
import scala.io.StdIn.*

object StringCompression {

  def main(args: Array[String]): Unit = {

    //Initialize Variables
    val string = readLine("Please enter a string to be compressed: ")
    val stringArray = string.split("") //Holds each character of the string
    val charList = ListBuffer[String]()      //Holds each character of the string (No duplicates)
    var counter = 0
    var resultStr = ""

    //Find unique characters in the string
    for (char <- stringArray) {
      if (!charList.contains(char)) {
        charList += char
      }
    }

    //Count each character in the string using the unique character list
    for (char <- charList) {
      for (a <- 0 until stringArray.length) {
        if (stringArray(a).equals(char)){
          counter += 1
        }
      }
      resultStr += (char + counter.toString)
      counter = 0
    }
    if (resultStr.length < stringArray.length){
      print(resultStr)
    }else{
      print(string)
    }

  }
}
