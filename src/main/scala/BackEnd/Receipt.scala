package BackEnd

import scala.collection.mutable.ListBuffer

class Receipt(itemsList: ListBuffer[Items], date1: String) {
  val items: ListBuffer[Items] = itemsList
  val date: String = date1

  def total: Double = calculatePrice(items)
  def calculatePrice(items: ListBuffer[Items]): Double = {
    var total: Double = 0
    items.foreach(x => total += x.price)
    total
  }

  override def toString: String = s"$date | $items"
}