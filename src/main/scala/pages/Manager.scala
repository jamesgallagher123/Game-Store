package pages

import scalafx.application.JFXApp
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control._

/**
  * Created by Administrator on 21/06/2017.
  */
object Manager extends JFXApp {
  val ButtonTypeOne = new ButtonType("One")
  val ButtonTypeTwo = new ButtonType("Two")
  val ButtonTypeThree = new ButtonType("Three")

  val alert = new Alert(AlertType.Confirmation) {
    initOwner(stage)
    title = "Confirmation Dialog with Custom Actions"
    headerText = "Look, a Confirmation Dialog with Custom Actions."
    contentText = "Choose your option."
    // Note that we override here default dialog buttons, OK and Cancel, with new ones.
    buttonTypes = Seq(ButtonTypeOne, ButtonTypeTwo, ButtonTypeThree, ButtonType.Cancel)
  }

  val result = alert.showAndWait()

  result match {
    case Some(ButtonTypeOne)   => println("... user chose One")
    case Some(ButtonTypeTwo)   => println("... user chose Two")
    case Some(ButtonTypeThree) => println("... user chose Three")
    case _                     => println("... user chose CANCEL or closed the dialog")
  }
}
