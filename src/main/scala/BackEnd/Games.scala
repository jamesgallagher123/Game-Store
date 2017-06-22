package BackEnd

class Games(idc:Int, fnc:String, pricec:Double, quantityc:Int, rdc: String) extends Items{
  val id: Int = idc
  val fullName: String = fnc
  val price: Double = pricec
  var quantity: Int = quantityc
  val releaseDate: String = rdc

  override def toString = s"Game | ID: $id | Name: $fullName | Price: $price"
}
