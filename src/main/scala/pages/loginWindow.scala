package pages

import scalafx.scene.Scene
import scalafx.scene.control.{Button, TextField}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.paint.Color._
import scalafx.scene.text.Text
import scalafx.Includes._
import scalafx.event.ActionEvent
import scalafx.scene.input.MouseEvent

class LoginWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
//  updateWindow

  val titleText: Text = new Text("Login") {
    relocate(140, 40)
    style = "-fx-font-size: 30pt"
    fill = Color.Black
  }

  val userBox = new TextField() {
    relocate(120, 80)
    promptText = "UserName"
  }

  val passBox = new TextField() {
    relocate(120, 110)
    promptText = "Password"
  }

  val loginConfirm: Button = new Button("Log In") {
    relocate(130, 140)
//    loginConfirm.onAction = (e: ActionEvent) => {
//
//    }
  }

  val close: Button = new Button("Close") {
    relocate(210, 140)
//    close.onMouseClicked = (e: MouseEvent) => {
//      Main.mainStage.closeWindow
//    }
  }
  //ComboBox - Dropdown list new ComboBox][Type](List())
  //var combo:ComboBox[String] = new ComboBox[String]("First option", "Second Option")
  //combo.getSelectionModel().getSelected.value
  //TextField - editable
  //TextArea
  //PromptText
  //ListView

  def updateWindow: Unit = {
    // Refresh the page
    userBox.setText("")
    passBox.setText("")
  }

  Main.setWindow("ManagerWindow")
  content = List(titleText, userBox, passBox, close, loginConfirm)
}
