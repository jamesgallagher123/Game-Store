class Hardware (i: Int, fn: String, p: Double, q: Int) extends Items{
  val id: Int = i
  val fullName: String = fn
  val price: Double = p
  val quantity: Int = q

  override def toString = s"Hardware | ID: $id | Full Name: $fullName | Price: $price | Quantity in Stock: $quantity"
}
