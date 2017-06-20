import org.scalatest._

class LoginTest extends FlatSpec with Matchers  {
  val login = new Login(floorStaff = new FloorStaff(i = 123, fn = "Fleur Staff"), manager = new Manager(i = 321, fn = "Manny Ager"))

  "valid floorstaff login" should "login correctly" in {
    login.loginScreenLogic(user = "fs1", pass = "fspass")
    login.userType shouldBe "floorstaff"
  }

  "valid manager login" should "login correctly" in {
    login.loginScreenLogic(user = "manager1", pass = "managerpass")
    login.userType shouldBe "manager"
  }
}
