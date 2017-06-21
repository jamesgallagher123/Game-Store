package pages

import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.paint.Color
import scalafx.scene.text.Text

/**
  * Created by Profile on 21/06/2017.
  */
class ManagerWindow extends Scene{

  var test:Text = new Text("Manager Operations"){
    relocate(160,30)
    style = "-fx-font-size: 20pt"
  }
  fill = Color.LightGray

  val crudOperationButton: Button = new Button("CRUD Operations")
  val transactionsButton: Button = new Button("Transactions")
  val reportsAndReceiptButton: Button = new Button("Receipts & Transactions")

  def updateWindow: Unit = {
    // Refresh the page
  }

  content = List(test, crudOperationButton, transactionsButton, reportsAndReceiptButton)

}
