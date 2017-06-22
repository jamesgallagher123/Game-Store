import java.util.Calendar

import BackEnd.{GameStore, Games}

object Runner extends App{
  val gameStore = new GameStore

  var game = new Games(1,"Best Game",5.99,5,"20/06/2017")
  // preOrderGame date needs to be set after today's date in order to result in true
  var preOrderGame = new Games(2,"Bad Game",6.99,5,"22/06/2017")
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
