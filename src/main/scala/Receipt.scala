class Receipt(floorStaff: FloorStaff, customer: Customer, itemId1: Int,
              itemName1: String, quantity1: Int, price1: Double, date1: String) {
  val floorStaffId: Int = floorStaff.id
  val customerId: Int = customer.id
  val itemId: Int = itemId1
  val itemName: String = itemName
  val quantity: Int = quantity1
  val price: Double = price1
  val date: String = date1
}
//comment