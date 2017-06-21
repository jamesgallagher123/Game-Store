package BackEnd

class Manager(i: Int, fn: String) extends Person{
   val id: Int = i
   val fullName: String = fn

  override def toString = s"BackEnd.Manager | ID: $id | Full Name: $fullName"


}
