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

  def newReceipt(): Unit = {
    receiptItems.clear
  }

  def buyGame(gameName: String, quantity: Int): Unit = {
    itemsListBuffer.foreach(i => {
      if (i.fullName == gameName) {
        if (i.quantity >= quantity) {
          for(j<-0 until quantity) {
            receiptItems += i
          }
          i.quantity -= quantity
        }
      }
    })
  }

  def checkout(): Unit = {
    val receipt = new Receipt(receiptItems, "today")
    receipt.total
  }

  def payWithPoints(id: Int, quantity: Int, customerid: Int) = {
    itemsListBuffer.foreach(i => if (i.id.equals(id)) {
      customerListBuffer.foreach(j => if (j.id.equals(customerid)) {
        if (j.points >= i.price && i.quantity >= quantity) {
          for(k <- 0 until quantity) {
            receiptItems += i
            j.points -= i.price.toInt
            println("Successfully purchased with points")
          }
        }
        else println("Invalid points to make purchase")
      })
      i.quantity -= quantity
    })
  }
}
