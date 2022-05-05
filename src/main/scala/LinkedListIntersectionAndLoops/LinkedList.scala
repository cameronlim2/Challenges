package LinkedListIntersectionAndLoops

import scala.collection.mutable.ListBuffer

class LinkedList(var head: Node, var tail: Node) {
  def this() = {
    this(null,null)
  }

  def addNode(data: Int): Unit = {
    var node: Node = new Node(data)
    if (this.head == null){
      this.head = node
    }else{
      this.tail.next = node
    }
    this.tail = node
  }

  def display(): Unit = {
    if (this.head == null) {
      println("Empty Linked List")
      return
    }
    var temp: Node = this.head
    while (temp != null){
      print(" " + temp.data + " -> ")
      temp = temp.next
    }
    println("NULL")
  }

  def intersection(l2: LinkedList): Unit = {
    var intersections: ListBuffer[Int] = new ListBuffer()
    var node: Node = this.head
    var node2: Node = l2.head

    while (node != null){
      if (node.data == node2.data){
        intersections += node.data
      }
      node = node.next
      node2 = node2.next
    }
    println("Intersections :  ")
    for (intersection <- intersections) {
      print(intersection + "  ")
    }
    println()
 }

  def checkLoop(): Unit ={
    var usedData: ListBuffer[Int] = new ListBuffer()
    var node: Node = this.head
    while (node != null){
      if (!usedData.contains(node.data)){
        usedData += node.data
      }else{
        println("Corrupted LL: Repetition at => " + node.data)
      }
      node = node.next
    }
  }
}
