import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Administrator on 20/06/2017.
  */
class BuyItemTest extends FlatSpec with Matchers {
  val gameStore = new GameStore
  var receipt = new Receipt(gameStore.receiptItems, "today")
  var game = new Games(1,"Best Game",5.99,5,"today")
  gameStore.itemsListBuffer += game

  "valid game purchase" should "reduce game quantity by 2" in {
    gameStore.buyGame("Best Game", 2)
    game.quantity shouldBe 3
  }

  "valid checkout" should "output correct subtotal" in {
    gameStore.buyGame("Best Game", 2)
    gameStore.checkout
    receipt.total shouldBe (5.99*2)
  }
}
