import scala.collection.mutable.ListBuffer

class Receipt(floorStaff: FloorStaff, customer: Customer, itemsList: ListBuffer[Items], date1: String) {
  val floorStaffId: Int = floorStaff.id
  val customerId: Int = customer.id
  val items: ListBuffer[Items] = itemsList
  val price: Double = calculatePrice(items)
  val date: String = date1

  def calculatePrice(items: ListBuffer[Items]): Double = {
    var total: Double = 0
    items.foreach(x => total += x.price * x.quantity)
    total
  }
}