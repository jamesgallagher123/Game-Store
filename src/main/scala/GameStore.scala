/**
  * Created by Administrator on 20/06/2017.
  */

import java.util.Calendar

import scala.collection.mutable._

class GameStore {
  var itemsListBuffer: ListBuffer[Item] = new ListBuffer[Item]
  var customerListBuffer: ListBuffer[Customer] = new ListBuffer[Customer]
  var floorStaffListBuffer: ListBuffer[FloorStaff] = new ListBuffer[FloorStaff]
  var receiptListBuffer: ListBuffer[Receipt] = new ListBuffer[Receipt]
  var receiptItems: ListBuffer[Item] = new ListBuffer[Item]

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
        else println("Not enough items in system")
      }
      else println("No such item in system")
    })
  }

  def checkout: Unit = {
    val receipt = new Receipt(receiptItems, "toitemDay")
    receipt.total
  }

  var itemDay: Int = 0
  var itemMonth: Int = 0
  var itemYear: Int = 0

  def readDate(input: String): Unit = {
    var date = input.split("/")
    itemDay = date(0).toInt
    itemMonth = date(1).toInt
    itemYear = date(2).toInt
  }

  var currentDay: Int = 0
  var currentMonth: Int = 0
  var currentYear: Int = 0

  def getCurrentDate: Unit = {
    val now = Calendar.getInstance()
    currentDay = now.get(Calendar.DAY_OF_MONTH)
    currentMonth = (now.get(Calendar.MONTH) + 1) //Java is stupid. January is apparently month 0, not month 1
    currentYear = now.get(Calendar.YEAR)
  }

  def canPreOrder(input: String): Boolean = {
    getCurrentDate
    readDate(input)
    if(itemYear>=currentYear && itemMonth>=currentMonth && itemDay>currentDay) true
    else false
  }

    def preOrder(itemName: String, q: Int): Unit = {
      itemsListBuffer.foreach(i => {
        if (i.fullName == itemName) {
          if(canPreOrder(i.releaseDate)) println("true")
          else println("false")
        }
      })
    }
}

