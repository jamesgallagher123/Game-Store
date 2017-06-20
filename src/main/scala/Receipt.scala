import scala.collection.mutable.ListBuffer

class Receipt(itemsList: ListBuffer[Item], date1: String) {
  val items: ListBuffer[Item] = itemsList
  val date: String = date1

  def total: Double = calculatePrice(items)
  def calculatePrice(items: ListBuffer[Item]): Double = {
    var total: Double = 0
    items.foreach(x => total += x.price)
    total
  }
}