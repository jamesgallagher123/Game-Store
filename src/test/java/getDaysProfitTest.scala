import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Administrator on 20/06/2017.
  */
class getDaysProfitTest extends FlatSpec with Matchers {
  val gameStore = new GameStore
  var game = new Games(1,"Best Game", 10, 1,"today")
  gameStore.itemsListBuffer += game
  gameStore.receiptListBuffer += new Receipt(gameStore.itemsListBuffer, "16/06/17")
  gameStore.receiptListBuffer += new Receipt(gameStore.itemsListBuffer, "16/06/17")

  "adding up 2 receipt totals" should "disply the correct profit" in {
    gameStore.getDaysProfit("16/06/17") shouldBe 20
  }

  "entering a date witch has no receipts" should "return 0" in {
    gameStore.getDaysProfit("01/01/01") shouldBe 0
  }

}