package pages

import BackEnd.GameStore

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

object Main extends JFXApp {
  var loginWindow:LoginWindow = new LoginWindow
  var managerWindow:ManagerWindow = new ManagerWindow
  var floorStaffWindow:FloorStaffWindow = new FloorStaffWindow
  var viewItemsWindow:ViewItemsWindow = new ViewItemsWindow
  var transactionsWindow:TransactionsWindow = new TransactionsWindow
  var customersWindow:CustomersWindow = new CustomersWindow
  var profitWindow:Reports = new Reports
  var mainStage:PrimaryStage = new PrimaryStage
  val gameStore = new GameStore
  setWindow("login")

  def setWindow(window:String): Unit = {
    window match {
      case "login" => mainStage.scene = loginWindow
        mainStage.width = 400
        mainStage.height = 350
        mainStage.title = "Log In"
        loginWindow.updateWindow
        mainStage.title = "Log In"
      case "floorstaff" => mainStage.scene = floorStaffWindow
        mainStage.width = 400
        mainStage.height = 350
      case "viewitems" => mainStage.scene = viewItemsWindow
        mainStage.width = 400
        mainStage.height = 350
      case "customers" => mainStage.scene = customersWindow
        mainStage.width = 400
        mainStage.height = 350
      case "transactions" => mainStage.scene = transactionsWindow
        mainStage.width = 400
        mainStage.height = 350
      case "manager" => mainStage.scene = managerWindow
        mainStage.width = 400
        mainStage.height = 350
      case "profits" => mainStage.scene = profitWindow
        mainStage.width = 400
        mainStage.height = 350
        profitWindow.updateWindow
      case _ => println("Window not valid")
    }
  }
}
