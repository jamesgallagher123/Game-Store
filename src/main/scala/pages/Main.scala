package pages

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

object Main extends JFXApp {
  var loginWindow:LoginWindow = new LoginWindow
  var managerWindow:ManagerWindow = new ManagerWindow
  //var floorStaffWindow:FloorStaffWindow = new FloorStaffWindow
  var mainStage:PrimaryStage = new PrimaryStage

  setWindow("login")

  def setWindow(window:String): Unit = {
    window match {
      case "login" => mainStage.scene = loginWindow
        mainStage.width = 400
        mainStage.height = 350
//      case "floorstaff" => mainStage.scene = floorStaffWindow
//        mainStage.width = 400
//        mainStage.height = 350
      case "manager" => mainStage.scene = managerWindow
        mainStage.width = 400
        mainStage.height = 350
      case _ => println("Window not valid")
    }
  }
}
