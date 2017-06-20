/**
  * Created by Profile on 19/06/2017.
  */
class Miscellaneous (miscellaneousId:Int, miscellaneousName:String, miscellaneousPrice:Double, miscellaneousQuantity:Int) extends Items{
  override var id: Int = miscellaneousId
  override var name: String = miscellaneousName
  override var price: Double = miscellaneousPrice
  override var quantity: Int = miscellaneousQuantity

  override def toString: String = "Miscellaneous=> " + super.toString

}
