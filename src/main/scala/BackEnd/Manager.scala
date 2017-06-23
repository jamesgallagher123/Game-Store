package BackEnd

class Manager(i: Int, fn: String, email:String) extends Person{
   val id: Int = i
   val fullName: String = fn
   val emailAddress: String = email
  override def toString = s"BackEnd.Manager | ID: $id | Full Name: $fullName | Email Address: $email"


}
