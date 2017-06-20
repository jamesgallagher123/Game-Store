import org.scalatest.{FlatSpec, Matchers}

class BuyItemTest extends FlatSpec with Matchers {
  val gameStore = new GameStore
  var receipt = new Receipt(gameStore.receiptItems, "20/06/2017")
  var game = new Game(1,"Best Game",5.99,5,"20/06/2017")
  gameStore.itemsListBuffer += game


  "valid game purchase" should "reduce game quantity by 2" in {
    gameStore.buyItem("Best Game", 2)
    game.quantity shouldBe 3
  }

  "valid checkout" should "output correct subtotal" in {
    gameStore.checkout
    receipt.total shouldBe 11.98
  }

  "valid new receipt" should "clear the receipt" in {
    gameStore.newReceipt
    gameStore.receiptItems.length shouldBe 0
  }
}