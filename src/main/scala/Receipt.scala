import scala.collection.mutable.ListBuffer

class Receipt(floorStaff: FloorStaff, customer: Customer, itemsList: ListBuffer[Items], price1: Double, date1: String) {
  val floorStaffId: Int = floorStaff.id
  val customerId: Int = customer.id
  val items: ListBuffer[Items] = itemsList
  val price: Double = price1
  val date: String = date1
}