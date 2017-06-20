class Games(idc:Int, fnc:String, pricec:Double, quantityc:Int, rdc:java.util.Date) extends Items{
  val id: Int = idc
  val fullName: String = fnc
  val price: Double = pricec
  val quantity: Int = quantityc
  val releaseDate: java.util.Date = rdc

  override def toString = s"Game | ID: $id | Full Name: $fullName | Price: $price | Quantity in Stock: $quantity | Release Date: $releaseDate"
}

