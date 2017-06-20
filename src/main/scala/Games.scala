/**
  * Created by Profile on 19/06/2017.
  */
class Games(idc:Int, fnc:String, pricec:Double, quantityc:Int, rdc:java.util.Date) extends Items{
  override val id: Int = idc
  override val fullName: String = fnc
  override val price: Double = pricec
  override val quantity: Int = quantityc
  val releaseDate: java.util.Date = rdc
}
