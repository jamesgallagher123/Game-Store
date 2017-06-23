package BackEnd

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


  def buyItem(itemName: String, q: Int, point: Boolean, customerId: Int): String = {
    var message: String = ""
    itemsListBuffer.foreach(i =>
      if (i.fullName == itemName) {
        customerListBuffer.foreach(j => if (j.id.equals(customerId)) {
          if (q != 0) {
            if (i.quantity >= q) {
              if (point.equals(true) && j.points >= i.price) {
                for (k <- 0 until q) {
                  receiptItems += i
                  j.points -= i.price.toInt
                }
                i.quantity -= q
                message = s"Item successfully purchased with points you now have ${j.points} left"
              } else if (point.equals(false)) {
                for (k <- 0 until q) {
                  receiptItems += i
                  j.points -= i.price.toInt
                }
                i.quantity -= q
                message = "Item successfully purchased"
              }
              else message = "Not enough points"
            } else message = "Not enough items in system"
          } else message = "No such customer"
        } else message = "No such item")})
    message
  }

  def checkout(): Receipt = {
    getCurrentDate
    val receipt = new Receipt(receiptItems, getCurrentDate)
    receiptListBuffer += receipt
    receipt
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

  def getCurrentDate: String = {
    val now = Calendar.getInstance()
    currentDay = now.get(Calendar.DAY_OF_MONTH)
    currentMonth = (now.get(Calendar.MONTH) + 1) //Java is stupid. January is apparently month 0, not month 1
    currentYear = now.get(Calendar.YEAR)
    return s"${currentDay.toString+"/"+currentMonth.toString+"/"+currentYear.toString}"
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

  def payWithPoints(id: Int, quantity: Int, customerid: Int): String = {
    var message = ""
    itemsListBuffer.foreach(i => if (i.id.equals(id)) {
      customerListBuffer.foreach(j => if (j.id.equals(customerid)) {
        if (j.points >= i.price && i.quantity >= quantity) {
          for(k <- 0 until quantity) {
            receiptItems += i
            j.points -= i.price.toInt
            message = "Successfully purchased with points"
          }
          i.quantity -= quantity
        }
        message = "Invalid points to make purchase"
      })
    })
    message
  }

  def expectedProfit: Double = {
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


  def printReceipt(receipt: Receipt, floorstaffName: String, paidWithPoints: Boolean, quantity: Int): String = {
    var a: String = ""
    var c = ""
    if (paidWithPoints.equals(false)) {
      receipt.items.foreach(i => a += s"ID: ${i.id} | Product: ${i.fullName} | Quantity: $quantity | Total Price: ${i.price * quantity}")
      println(a)
      val b: String = "\nYou have been served by " + floorstaffName + "\n"
      c = a + b
    }
    if (paidWithPoints.equals(true)) {
      receipt.items.foreach(i => a += s"ID: ${i.id} | Product: ${i.fullName} | Quantity: $quantity | Total Price: ${i.price * quantity}")
      println(a)
      val b: String = "\nYou have been served by " + floorstaffName +  "\nYou have paid using points"
      c = a + b
    }
    c
  }
}

