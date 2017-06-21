import org.scalatest._

class payWithPointsTest extends FlatSpec with Matchers {
  val gamestore = new GameStore
  val game = new Games(1234, "xbox game", 50, 5, "18/06/2017")
  gamestore.itemsListBuffer += game
  val customer = new Customer(5678, "Cust Omer", 100)
  gamestore.customerListBuffer += customer

  "buying item worth 50 points when you have 100 points" should "be successful" in {
    gamestore.payWithPoints(id = 1234, quantity = 1, customerid = 5678)
    game.quantity shouldBe 4
    customer.points shouldBe 50
  }

  val gamestore1 = new GameStore
  val game1 = new Games(1234, "xbox game", 100, 5, "18/06/2017")
  gamestore1.itemsListBuffer += game1
  val customer1 = new Customer(5678, "Cust Omer", 50)
  gamestore1.customerListBuffer += customer1

  "buying item worth 100 points when you have 50 points" should "be successful" in {
    gamestore1.payWithPoints(id = 1234, quantity = 1, customerid = 5678)
    game.quantity shouldBe 5
    customer.points shouldBe 100
  }


}
