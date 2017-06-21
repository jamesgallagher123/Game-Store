import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.ListBuffer

class PrintReceiptTest extends FlatSpec with Matchers {
  val gameStore = new GameStore
  val receiptItems1 =  new Games(4564, "xbox game", 14.50, 3, "13/05/2016")
  val receiptItems2 =  new Hardware(4321, "xbox one", 249.99, 1, "01/01/1901")
  gameStore.itemsListBuffer += receiptItems1
  gameStore.itemsListBuffer += receiptItems2
  val receipt = new Receipt(gameStore.itemsListBuffer, "20/06/2017")
  val floorStaff = new FloorStaff(12345, "Fleur Staff")

  "check printing valid receipt without points purchase" should "print sucessfully" in {
    gameStore.printReceipt(receipt, floorStaff, false) shouldBe 293.49
  }

  "check printing a valid receipt if user has paid with points"
  gameStore.printReceipt(receipt, floorStaff, true) shouldBe 293.49
}
