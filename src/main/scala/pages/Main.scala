package pages

import BackEnd.GameStore
import pages.ManagerScreens.Reports

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

object Main extends JFXApp {
  var loginWindow:LoginWindow = new LoginWindow
  var managerWindow:ManagerScreens.ManagerWindow = new ManagerScreens.ManagerWindow
  var transactionsWindowManager:ManagerScreens.TransactionsWindow = new ManagerScreens.TransactionsWindow
  var viewGamesWindowManager:ManagerScreens.ViewGamesWindow = new ManagerScreens.ViewGamesWindow
  var viewItemsWindowManager:ManagerScreens.ViewItemsWindow = new ManagerScreens.ViewItemsWindow
  var viewHardwareWindowManager:ManagerScreens.ViewHardwareWindow = new ManagerScreens.ViewHardwareWindow
  var viewMiscWindowManager:ManagerScreens.ViewMiscWindow = new ManagerScreens.ViewMiscWindow
  var floorStaffWindow:FloorStaffWindow = new FloorStaffWindow
  var viewItemsWindow:ViewItemsWindow = new ViewItemsWindow
  var viewGamesWindow:ViewGamesWindow = new ViewGamesWindow
  var viewHardwareWindow:ViewHardwareWindow = new ViewHardwareWindow
  var viewMiscWindow:ViewMiscWindow = new ViewMiscWindow
  var transactionsWindow:TransactionsWindow = new TransactionsWindow
  var customersWindow:CustomersWindow = new CustomersWindow
  var profitWindow:ManagerScreens.Reports = new ManagerScreens.Reports
  var mainStage:PrimaryStage = new PrimaryStage
  var crudWindow:ManagerScreens.CRUDWindow = new ManagerScreens.CRUDWindow
  var crudItemsWindow:ManagerScreens.CRUDItemsWindow = new ManagerScreens.CRUDItemsWindow
  var crudCustomersWindow:ManagerScreens.CRUDCustomersWindow = new ManagerScreens.CRUDCustomersWindow
  var crudStaffWindow:ManagerScreens.CRUDStaffWindow = new ManagerScreens.CRUDStaffWindow
  val gameStore = new GameStore

  val floorStaffCreateCustomer:FloorStaffCreateCustomer = new FloorStaffCreateCustomer
  val floorStaffReadCustomer:FloorStaffReadCustomer = new FloorStaffReadCustomer
  val floorStaffEditCustomer:FloorStaffEditCustomer = new FloorStaffEditCustomer
  val floorStaffDeleteCustomer:FloorStaffDeleteCustomer = new FloorStaffDeleteCustomer

  setWindow("floorstaff")

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
      case "floorStaffCreateCustomer" => mainStage.scene = floorStaffCreateCustomer
        mainStage.width = 400
        mainStage.height = 350
      case "floorStaffReadCustomer" => mainStage.scene = floorStaffReadCustomer
        mainStage.width = 400
        mainStage.height = 350
      case "floorStaffEditCustomer" => mainStage.scene = floorStaffEditCustomer
        mainStage.width = 400
        mainStage.height = 350
      case "floorStaffDeleteCustomer" => mainStage.scene = floorStaffDeleteCustomer
        mainStage.width = 400
        mainStage.height = 350
      case "viewitems" => mainStage.scene = viewItemsWindow
        mainStage.width = 400
        mainStage.height = 350
      case "viewItemsManager" => mainStage.scene = viewItemsWindowManager
        mainStage.width = 400
        mainStage.height = 350
      case "viewGames" => mainStage.scene = viewGamesWindow
        mainStage.width = 550
        mainStage.height = 350
      case "viewGamesManager" => mainStage.scene = viewGamesWindowManager
        mainStage.width = 550
        mainStage.height = 350
      case "viewHardware" => mainStage.scene = viewHardwareWindow
        mainStage.width = 400
        mainStage.height = 350
      case "viewHardwareManager" => mainStage.scene = viewHardwareWindowManager
        mainStage.width = 400
        mainStage.height = 350
      case "viewMisc" => mainStage.scene = viewMiscWindow
        mainStage.width = 400
        mainStage.height = 350
      case "viewMiscManager" => mainStage.scene = viewMiscWindowManager
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
