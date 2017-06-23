package pages

import BackEnd.GameStore
import pages.ReportsAndReceipts.Reports

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

object Main extends JFXApp {
  var loginWindow:LoginWindow = new LoginWindow
  var managerWindow:ManagerWindow = new ManagerWindow
  var floorStaffWindow:FloorStaffWindow = new FloorStaffWindow
  var viewItemsWindow:ViewItemsWindow = new ViewItemsWindow
  var viewGamesWindow:ViewGamesWindow = new ViewGamesWindow
  var viewGamesWindowManager:ViewGamesWindowManager = new ViewGamesWindowManager
  var viewHardwareWindow:ViewHardwareWindow = new ViewHardwareWindow
  var viewMiscWindow:ViewMiscWindow = new ViewMiscWindow
  var transactionsWindow:TransactionsWindow = new TransactionsWindow
  var transactionsWindowManager:TransactionsWindowManager = new TransactionsWindowManager
  var customersWindow:CustomersWindow = new CustomersWindow
  var profitWindow:Reports = new Reports
  var mainStage:PrimaryStage = new PrimaryStage
  var crudWindow:CRUDWindow = new CRUDWindow
  var crudItemsWindow:CRUDItemsWindow = new CRUDItemsWindow
  var crudCustomersWindow:CRUDCustomersWindow = new CRUDCustomersWindow
  var crudStaffWindow:CRUDStaffWindow = new CRUDStaffWindow
  val gameStore = new GameStore
  setWindow("crud")




  def setWindow(window:String): Unit = {
    window match {
      case "login" => mainStage.scene = loginWindow
        mainStage.width = 400
        mainStage.height = 350
        mainStage.title = "Log In"
        loginWindow.updateWindow
      case "floorstaff" => mainStage.scene = floorStaffWindow
        mainStage.width = 400
        mainStage.height = 350
      case "viewitems" => mainStage.scene = viewItemsWindow
        mainStage.width = 400
        mainStage.height = 350
      case "viewGames" => mainStage.scene = viewGamesWindow
        mainStage.width = 550
        mainStage.height = 350
      case "viewHardware" => mainStage.scene = viewHardwareWindow
        mainStage.width = 400
        mainStage.height = 350
      case "viewMisc" => mainStage.scene = viewMiscWindow
        mainStage.width = 400
        mainStage.height = 350
      case "customers" => mainStage.scene = customersWindow
        mainStage.width = 400
        mainStage.height = 350
      case "transactions" => mainStage.scene = transactionsWindow
        mainStage.width = 400
        mainStage.height = 350
      case "transactionsmanager" => mainStage.scene = transactionsWindowManager
        mainStage.width = 400
        mainStage.height = 350
      case "manager" => mainStage.scene = managerWindow
        mainStage.width = 400
        mainStage.height = 350
      case "crud" => mainStage.scene = crudWindow
        mainStage.width = 400
        mainStage.height = 350
      case "crudItems" => mainStage.scene = crudItemsWindow
        mainStage.width = 400
        mainStage.height = 350
      case "crudCustomers" => mainStage.scene = crudCustomersWindow
        mainStage.width = 400
        mainStage.height = 350
      case "crudStaff" => mainStage.scene = crudStaffWindow
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
