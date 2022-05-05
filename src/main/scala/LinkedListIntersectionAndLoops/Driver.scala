package LinkedListIntersectionAndLoops

object Driver {


  def main(args: Array[String]): Unit = {
    var list1 = new LinkedList()
    var list2 = new LinkedList()
    var flag = 0

    //List 1
    list1.addNode(1)
    list1.addNode(2)
    list1.addNode(3)
    list1.addNode(4)
    list1.addNode(2)
    list1.addNode(10)
    list1.addNode(1)

    //List 2
    list2.addNode(7)
    list2.addNode(8)
    list2.addNode(3)
    list2.addNode(9)
    list2.addNode(1)
    list2.addNode(10)
    list2.addNode(13)

    println("Linked Lists: ")
    list1.display()
    list2.display()
    println()
    list1.intersection(list2)
    println()
    println("Checking LinkedList1 for Corruption: ")
    list1.checkLoop()


  }
}
