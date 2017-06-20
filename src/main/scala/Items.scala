/**
  * Created by Profile on 19/06/2017.
  */
abstract class Items {

  var id: Int
  var name: String
  var price: Double
  var quantity: Int

  override def toString: String = s"name $name, price $price, quantity $quantity"
}
