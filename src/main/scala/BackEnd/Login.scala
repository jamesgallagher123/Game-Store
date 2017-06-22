package BackEnd

import java.util.Scanner

class Login(floorStaff: FloorStaff, manager: Manager) {
  val floorstaffLogin: String = "fs1"
  val floorstaffPassword: String = "fspass"
  val managerLogin: String = "manager1"
  val managerPassword: String = "managerpass"
  var userType: String = _

  def loginScreenInput(): Unit  = {
    val sc = new Scanner(System.in)
    var username: String = sc.next()
    var password: String = sc.next()
    println("~BackEnd.Login~")
    println("Username: " + username)
    println("Password: " + password)
    loginScreenLogic(username, password)
  }

  def loginScreenLogic(user: String, pass: String) = {
    if (user == floorstaffLogin && pass == floorstaffPassword) {
      println("floorstaff login successful")
      userType = "floorstaff"
    }
    else if (user == managerLogin && pass == managerPassword) {
      println("manager login successful")
      userType = "manager"
    }
    else {
      println("Username or password was incorrect")
      loginScreenInput()
    }
  }
}
