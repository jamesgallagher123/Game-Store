import org.scalatest._

class LoginTest extends FlatSpec with Matchers  {
  "valid floorstaff login" should "login correctly" in {
    val login = new Login(floorStaff = new FloorStaff(i = 123, fn = "Fleur Staff"), manager = new Manager(i = 321, fn = "Manny Ager"))
    login.loginScreenLogic(user = "fs1", pass = "fspass")
    login.userType shouldBe "floorstaff"

  }
}
