import java.util.Scanner

class Login(floorStaff: FloorStaff, manager: Manager) {
  val floorstaffLogin: String = "fs1"
  val floorstaffPassword: String = "fspass"
  val managerLogin: String = "manager1"
  val managerPassword: String = "managerpass"
  val sc = new Scanner(System.in)
  var userType: String = _
  var username: String = sc.next()
  var password: String = sc.next()

  def loginScreenInput(): Unit  = {
    println("~Login~")
    println("Username: " + username)
    println("Password: " + password)
    loginScreenLogic(username, password)
  }

  def loginScreenLogic(user: String, pass: String) = {
    if (username == floorstaffLogin && password == floorstaffPassword) {
      println("floorstaff login successful")
      userType = "floorStaff"
    }
    else if (username == managerLogin && password == managerPassword) {
      println("manager login successful")
      userType = "manager"
    }
    else {
      println("Username or password was incorrect")
      loginScreenInput()
    }
  }
}
