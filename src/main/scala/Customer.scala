class Customer(i: Int, fn: String) extends Person{
  val id: Int = i
  val fullName: String = fn
  var points: Int = 0

  override def toString = s"Customer | ID: $id | Full Name: $fullName | User Points: $points "
}