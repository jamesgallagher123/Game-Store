package JDBCCRUD.GUI

/**
  * Created by Profile on 21/06/2017.
  */
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

object Main extends JFXApp {
  var crudWindow:CRUDOperationsWindow = new CRUDOperationsWindow
  var transactionsWindow: TransactionsWindow = new TransactionsWindow
  var reportsAndReceiptsWindow: ReportsAndReceiptsWindow = new ReportsAndReceiptsWindow


  var mainStage:PrimaryStage = new PrimaryStage

  setWindow("CRUD Operations")
  // val close:Button = new Button("Close"){relocate(x, y))
  // close.onAction = (e:ActionEvent) => {}
  // import scalafx.Include._
  def setWindow(window:String): Unit = {
    window match {
      case "CRUD Operations" => mainStage.scene = crudWindow
        mainStage.width = 400
        mainStage.height = 350
      case _ => println("Window not valid")
    }
  }

}