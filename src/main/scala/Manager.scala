class Manager(i: Int, fn: String) extends Person{
   var id: Int = i
   var fullName: String = fn

  override def toString = s"Manager | ID: $id | Full Name: $fullName"


}
