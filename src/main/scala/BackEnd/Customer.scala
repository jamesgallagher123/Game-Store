package BackEnd

class Customer(i: Int, fn: String, p: Int) extends Person{
  val id: Int = i
  val fullName: String = fn
  var points: Int = p

  override def toString = s"BackEnd.Customer | ID: $id | Full Name: $fullName | User Points: $points"
}