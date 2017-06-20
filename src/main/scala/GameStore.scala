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

  def buyGame(gameName: String, q: Int): Unit = {
    itemsListBuffer.foreach(i => {
      if (i.fullName == gameName) {
        if (i.quantity >= q) {
          for (j <- 0 until q) {
            receiptItems += i
            i.quantity -= 1
          }
        }
      }
    })
  }

  def checkout: Unit = {
    val receipt = new Receipt(receiptItems, "today")
    receipt.total
  }
}

