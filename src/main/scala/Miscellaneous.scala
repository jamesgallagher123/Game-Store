/**
  * Created by Profile on 19/06/2017.
  */
class Miscellaneous extends Items{
  override val id: Int = _
  override val fullName: String = _
  override val price: Double = _
  override val quantity: Int = _

  override def toString = s"Misc | ID: $id | Full Name: $fullName | Price: $price | Quantity in Stock: $quantity"
}
