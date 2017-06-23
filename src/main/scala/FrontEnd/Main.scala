package FrontEnd

import BackEnd.GameStore
import FrontEnd.GUI.{CustomersWindow, TransactionsWindow}
import FrontEnd._

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

object Main extends JFXApp {
  var loginWindow:LoginWindow = new LoginWindow
  var managerWindow:ManagerWindow = new ManagerWindow
  var floorStaffWindow:FloorStaffWindow = new FloorStaffWindow
  var viewItemsWindow:ViewItemsWindow = new ViewItemsWindow
  var transactionsWindow:TransactionsWindow = new TransactionsWindow
  var customersWindow:CustomersWindow = new CustomersWindow

  var createCustomer:CreateCustomer = new CreateCustomer
  var createItem:CreateItem = new CreateItem
  var createEmployee:CreateEmployee = new CreateEmployee

  var profitWindow:ViewProfits = new ViewProfits

  var mainStage:PrimaryStage = new PrimaryStage

  val gameStore = new GameStore
  setWindow("profits")

  setWindow("create customer")

  def setWindow(window:String): Unit = {
    window match {
      case "login" => mainStage.scene = loginWindow
        mainStage.width = 400
        mainStage.height = 350
        loginWindow.updateWindow
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

      case "profits" => mainStage.scene = profitWindow
        mainStage.width = 400
        mainStage.height = 350

      case _ => println("Window not valid")
    }
  }
}
