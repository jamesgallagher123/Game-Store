class FloorStaff (i: Int, fn: String) extends Person {
  val id: Int = i
  val fullName: String = fn

  override def toString = s"Floor Staff | ID: $id | Full Name: $fullName"
}