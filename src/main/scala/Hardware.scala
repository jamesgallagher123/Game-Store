/**
  * Created by Profile on 19/06/2017.
  */
class Hardware (hardwareId:Int, hardwareName:String, hardwarePrice:Double, hardwareQuantity:Int) extends Items{

  override var id: Int = hardwareId
  override var name: String = hardwareName
  override var price: Double = hardwarePrice
  override var quantity: Int = hardwareQuantity

  override def toString: String = "Hardware => " + super.toString

}
