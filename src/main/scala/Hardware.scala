/**
  * Created by Profile on 19/06/2017.
  */
class Hardware(idc:Int, fnc:String,pricec:Double,quantityc:Int) extends Items{
  override val id: Int = idc
  override val fullName: String = fnc
  override val price: Double = pricec
  override val quantity: Int = quantityc
}
