/**
  * Created by Administrator on 20/06/2017.
  */
object Runner extends App{
  val gameStore = new GameStore

  var game = new Games(1,"Best Game",5.99,5,"today")
  println(game)
  gameStore.itemsListBuffer += game
  gameStore.buyGame("Best Game", 2)

  println(game)

  gameStore.checkout

}
