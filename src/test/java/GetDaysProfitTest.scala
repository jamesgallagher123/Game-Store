import BackEnd.{GameStore, Games, Receipt}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Administrator on 22/06/2017.
  */


class ExpectedProfit extends FlatSpec with Matchers {
  val gameStore = new GameStore
  val gameStore1 = new GameStore
  var game = new Games(1, "Best Game", 10, 1, "01/01/16")
  var game1 = new Games(2, "A Game", 20, 1, "01/01/16")
  var game2 = new Games(3, "B Game", 15, 1, "01/01/16")
  var game3 = new Games(4, "C Game", 30, 1, "01/01/16")

  gameStore.itemsListBuffer += game
  gameStore.itemsListBuffer += game1
  gameStore.itemsListBuffer += game2
  gameStore.itemsListBuffer += game3

  gameStore1.itemsListBuffer += game1

  gameStore1.receiptListBuffer += new Receipt(gameStore1.itemsListBuffer, "16/06/17")
  gameStore1.receiptListBuffer += new Receipt(gameStore1.itemsListBuffer, "15/06/17")
  gameStore1.receiptListBuffer += new Receipt(gameStore.itemsListBuffer, "14/06/17")
  gameStore1.receiptListBuffer += new Receipt(gameStore.itemsListBuffer, "13/06/17")

  gameStore.receiptListBuffer += new Receipt(gameStore.itemsListBuffer, "16/06/17")
  gameStore.receiptListBuffer += new Receipt(gameStore.itemsListBuffer, "15/06/17")
  gameStore.receiptListBuffer += new Receipt(gameStore.itemsListBuffer, "14/06/17")
  gameStore.receiptListBuffer += new Receipt(gameStore.itemsListBuffer, "13/06/17")


  "adding up a number of receipt totals from different dates" should "display the correct profit" in {
    gameStore.expectedProfit shouldBe 75
  }

  "entering a date which has no receipts" should "return 0" in {
    gameStore.getDaysProfit("01/01/01") shouldBe 0
  }

  "calculating an average profit" should "return total profit of receipts divided by the number of days" in {
    gameStore1.expectedProfit shouldBe 47.50
  }

}
