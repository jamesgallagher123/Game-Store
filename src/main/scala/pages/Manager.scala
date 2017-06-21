package pages

import scalafx.application.JFXApp
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control._

/**
  * Created by Administrator on 21/06/2017.
  */
object Manager extends JFXApp {
  val ButtonTypeOne = new ButtonType("Transactions")
  val ButtonTypeTwo = new ButtonType("Reports & Receipts")
  val ButtonTypeThree = new ButtonType("CRUD Operations")

  val alert = new Alert(AlertType.Confirmation) {
    initOwner(stage)
    title = "Manager Homescreen"
    headerText = "Select Your Option:"
    contentText = "- Transactions\n\n- Reports & Receipts\n  - Reports\n  - Receipts\n\n- CRUD Operations\n  - Items\n  - Customers\n  - Staff\n"
    // Note that we override here default dialog buttons, OK and Cancel, with new ones.
    buttonTypes = Seq(ButtonTypeOne, ButtonTypeTwo, ButtonTypeThree, ButtonType.Cancel)
  }

  val result = alert.showAndWait()

  result match {
    case Some(ButtonTypeOne)   => println("... user chose Transactions")
    case Some(ButtonTypeTwo)   => println("... user chose Reports & Receipts")
    case Some(ButtonTypeThree) => println("... user chose CRUD Operations")
    case _                     => println("... user chose CANCEL or closed the dialog")
  }
}
