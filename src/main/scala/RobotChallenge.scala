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

    var possibleRow = List(1,2,3)
    possibleRow = scala.util.Random.shuffle(possibleRow)
    possibleRow.foreach(println)
    for (num <- possibleRow) {
      num match {
        case 1 => {
          grid.append(row1)
        }
        case 2 => {
          grid.append(row2)
        }
        case 3 => {
          grid.append(row3)
        }
      }
    }
    grid.append(row4)
    grid
  }


  def main(args: Array[String]): Unit = {
    var grid = createGrid()
    grid.foreach(println)
    println()
    grid = createGrid()
    grid.foreach(println)
  }

}
