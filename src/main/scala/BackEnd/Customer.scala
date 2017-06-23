package BackEnd

class Customer(i: Int, fn: String, email: String, p: Int) extends Person{
  val id: Int = i
  val fullName: String = fn
  var points: Int = p
  val emailAddress: String = email

  override def toString = s"BackEnd.Customer | ID: $id | Full Name: $fullName | Email Address: $email | User Points: $points"
}