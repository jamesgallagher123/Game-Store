/**
  * Created by Profile on 19/06/2017.
  */
class Games (gameId:Int, gameName:String, gamePrice:Double, gameQuantity:Int, gameGenre:String, gameReleaseDate:String) extends Items{

override var id:Int = gameId
override var name: String = gameName
override var price: Double = gamePrice
override var quantity:Int = gameQuantity
var genre:String = gameGenre
var releaseDate:String = gameReleaseDate

  override def toString: String = "Games => " + super.toString

}
