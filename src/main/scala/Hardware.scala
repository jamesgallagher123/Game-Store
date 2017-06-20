/**
  * Created by Profile on 19/06/2017.
  */

class Hardware (i: Int, fn: String, p: Double, q: Int, rdc: String) extends Item{
  val id: Int = i
  val fullName: String = fn
  val price: Double = p
  var quantity: Int = q
  val releaseDate: String = rdc

  override def toString = s"Hardware | ID: $id | Full Name: $fullName | Price: $price | Quantity in Stock: $quantity"
}
