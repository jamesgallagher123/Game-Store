/**
  * Created by Administrator on 20/06/2017.
  */

import java.util.Calendar

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
        else println("Not enough items in system")
      }
      else println("No such item in system")
    })
  }

  def checkout(): Unit = {
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
          i.quantity -= quantity
        }
        else println("Invalid points to make purchase")
      })
    })
  }

  def expectedProfit(): Double = {
    //find every date that has a receipt
    var dates: Set[String] = Set()
    receiptListBuffer.foreach { x =>
      dates += x.date
    }
    var total: Double = 0
    var numberOfDays = dates.size
    //add up total of each day and divide by number of days
    dates.foreach(x => total += getDaysProfit(x))
    total / numberOfDays
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

