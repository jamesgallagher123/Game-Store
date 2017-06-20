import java.util.Calendar

object Runner extends App{
  val gameStore = new GameStore

  var game = new Game(1,"Best Game",5.99,5,"20/06/2017")
  var preOrderGame = new Game(2,"Bad Game",6.99,5,"21/06/2017")
  println(game)
  println(preOrderGame)
  gameStore.itemsListBuffer += game
  gameStore.itemsListBuffer += preOrderGame
//  gameStore.buyItem("Best Game", 2)
//
//  println(game)
//
//  gameStore.checkout

  gameStore.preOrder("Best Game", 1)
  gameStore.preOrder("Bad Game", 1)
}
