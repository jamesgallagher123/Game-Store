/**
  * Created by Administrator on 20/06/2017.
  */

import scala.collection.mutable._

class GameStore {
  var itemsListBuffer: ListBuffer[Items] = new ListBuffer[Items]
  var customerListBuffer: ListBuffer[Customer] = new ListBuffer[Customer]
  var floorStaffListBuffer: ListBuffer[FloorStaff] = new ListBuffer[FloorStaff]
  var receiptListBuffer: ListBuffer[Receipt] = new ListBuffer[Receipt]
  var receiptItems: ListBuffer[Items] = new ListBuffer[Items]

  def getDaysProfit(date: String): Double = {
    var profit: Double = 0
    receiptListBuffer.foreach(x =>
      if (x.date == date) {
        profit += x.total
      }
    )
    profit
  }

  def getDaysSales(date: String): Unit = {
    receiptListBuffer.foreach(x =>
      if (x.date == date) {
        println(x.items)
      }
    )
  }

  def newReceipt: Unit = {
    receiptItems.clear
  }

  def buyItem(itemName: String, q: Int): Unit = {
    itemsListBuffer.foreach(i => {
      if (i.fullName == itemName) {
        if (i.quantity >= q) {
          for (j <- 0 until q) {
            receiptItems += i
          }
          i.quantity -= q
        }
      }
    })
  }

  def checkout(): Unit = {
    val receipt = new Receipt(receiptItems, "today")
    receipt.total
  }

  var pointsLeft: Int = 0
  def payWithPoints(id: Int, quantity: Int, customerid: Int) = {
    itemsListBuffer.foreach(i => if (i.id.equals(id)) {
      customerListBuffer.foreach(j => if (j.id.equals(customerid)) {
        if (j.points >= i.price && i.quantity >= quantity) {
          for(k <- 0 until quantity) {
            receiptItems += i
            j.points -= i.price.toInt
            pointsLeft = j.points
            println("Successfully purchased with points")
          }
        }
        else println("Invalid points to make purchase")
      })
      i.quantity -= quantity
    })
  }

  def printReceipt(receipt: Receipt, floorStaff: FloorStaff, paidWithPoints: Boolean): Double = {
    receipt.items.foreach(i =>println(s"ID: ${i.id} | Product: ${i.fullName} | Quantity: ${i.quantity} | Total Price: ${i.price*i.quantity}"))
    println("You have been served by " + floorStaff.fullName)
    if (paidWithPoints.equals(true)) {
      println(s"You have paid with points")
    }
    var a: Double = 0
    receipt.items.foreach(i => a += i.price*i.quantity)
    println(s"Total Order Price: $a")
    a
  }
}
