import scala.collection.mutable.ListBuffer
import java.util.Random

object RobotChallenge {
  val rs = new Random()

  def createGrid(): ListBuffer[(Int,Int,Int,Int,Int)] = {
    var grid : ListBuffer[(Int,Int,Int,Int,Int)] = ListBuffer()

    val row0 = (0,1,0,0,0)
    val row1 = (1,0,0,0,0)
    val row2 = (0,0,1,0,0)
    val row3 = (0,0,0,0,1)
    val row4 = (0,0,0,1,0)

    grid.append(row0)

    var possibleRow = List(2,3)
    possibleRow = scala.util.Random.shuffle(possibleRow)
    possibleRow.foreach(println)
    for (num <- possibleRow) {
      num match {
        case 2 => {
          grid.append(row2)
        }
        case 3 => {
          grid.append(row3)
        }
      }
    }
    grid.append(row1)
    grid.append(row4)
    grid
  }
  // We will handle each row seperately. We will keep a history of our ending position in a row by passing a tuple of both the ending position (Int) and the row's updated path string.
  def findRowPath(row: (Int,Int,Int,Int,Int), position: Int): (Int,String) ={
    var counter = 0
    var exitIndex = 0
    var rowString = "("
    val newList = List[Int](row(0), row(1),row(2),row(3),row(4))

    //Find where the 1 is in the row (exitIndex)
    for (num <- newList){
      if (num == 1){
        exitIndex = counter
      }
      counter+=1
    }
    //If we are already in a position from the previous row that puts us past the 1, go to the end.
    if (position > exitIndex){
      exitIndex = newList.length
    }
    // If we start in a position past the first column, add original information from the original row
    for (a <- 0 until position){
      rowString += newList(a).toString + ","
    }
    // From the position we are located until we hit 1 or the end, add 8 to represent a robot footprint.
    for (a <- position until exitIndex){
      if (a == newList.length-1){
        rowString += "8"
      }else{
        rowString += "8,"
      }
    }
    // If we hit a one, then add the 1 and following 0's to the path to finish.
    for (a <- exitIndex until newList.length){
      if (a == newList.length-1){
        rowString += newList(a).toString
      }else {
        rowString += newList(a).toString + ","
      }
    }
    return (exitIndex-1, rowString + ")")
  }


  def main(args: Array[String]): Unit = {
    var grid = createGrid()
    var finalGrid : ListBuffer[(Int,Int,Int,Int,Int)] = ListBuffer()
    grid.foreach(println)
    var position = 0
    println()
    for (row <- grid) {
      var (test, rowString) = findRowPath(row, position)
      position = test
      println(rowString)
    }
  }

}
