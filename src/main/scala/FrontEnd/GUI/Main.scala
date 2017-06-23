package FrontEnd.GUI

import BackEnd.GameStore
import FrontEnd.{CreateEmployee, CreateItem, ManagerWindow, ViewItemsWindow}
import pages.pages.ReportsAndReceipts.Reports
import pages.{TransactionsWindow, ViewGamesWindow, ViewHardwareWindow, ViewMiscWindow}

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

object Main extends JFXApp {
  var loginWindow:LoginWindow = new LoginWindow
  var managerWindow:ManagerWindow = new ManagerWindow
  var floorStaffWindow:FloorStaffWindow = new FloorStaffWindow
  var viewItemsWindow:ViewItemsWindow = new ViewItemsWindow
  var viewGamesWindow:ViewGamesWindow = new ViewGamesWindow
  var viewHardwareWindow:ViewHardwareWindow = new ViewHardwareWindow
  var viewMiscWindow:ViewMiscWindow = new ViewMiscWindow
  var transactionsWindow:TransactionsWindow = new TransactionsWindow
  var customersWindow:CustomersWindow = new CustomersWindow
  var profitWindow:Reports = new Reports
  var mainStage:PrimaryStage = new PrimaryStage
  var crudWindow:CRUDWindow = new CRUDWindow
  var crudItemsWindow:CRUDItemsWindow = new CRUDItemsWindow
  var crudCustomersWindow:CRUDCustomersWindow = new CRUDCustomersWindow
  var crudStaffWindow:CRUDStaffWindow = new CRUDStaffWindow


  var createCustomer:CreateCustomer = new CreateCustomer
  var createItem:CreateItem = new CreateItem
  var createEmployee:CreateEmployee = new CreateEmployee

  var deleteCustomer:DeleteCustomerWindow = new DeleteCustomerWindow
  var deleteItem:DeleteItemWindow = new DeleteItemWindow
  var delteEmployee:DeleteEmployeeWindow = new DeleteEmployeeWindow

  val gameStore = new GameStore
  setWindow("manager")

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


      case "create customer" => mainStage.scene = createCustomer
        mainStage.width = 400
        mainStage.height = 350
        createCustomer.updateWindow

      case "create item" => mainStage.scene = createItem
        mainStage.width = 400
        mainStage.height = 350
        createItem.updateWindow

      case "create employee" => mainStage.scene = createEmployee
        mainStage.width = 400
        mainStage.height = 350
        createEmployee.updateWindow


      case "delete customer" => mainStage.scene = deleteCustomer
        mainStage.width = 550
        mainStage.height = 350

      case "delete item" => mainStage.scene = deleteItem
        mainStage.width = 550
        mainStage.height = 350

      case "delete employee" => mainStage.scene = delteEmployee
        mainStage.width = 550
        mainStage.height = 350

      case _ => println("Window not valid")
    }
  }
}
