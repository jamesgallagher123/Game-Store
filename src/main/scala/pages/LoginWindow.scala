package pages

import scalafx.scene.Scene
import scalafx.scene.control.{Button, PasswordField, TextField}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.paint.Color._
import scalafx.scene.text.Text
import scalafx.Includes._
import scalafx.scene.input.MouseEvent

class LoginWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))

//  updateWindow

  val titleText: Text = new Text("Log In") {
    relocate(135, 40)
    style = "-fx-font-size: 30pt"
    fill = Color.Black
  }

  val userBox = new TextField() {
    relocate(120, 80)
    promptText = "UserName"
  }

  val passBox = new PasswordField() {
    relocate(120, 110)
    promptText = "Password"
  }

  val loginConfirm: Button = new Button("Log In") {
    relocate(130, 140)
    onMouseClicked = (e: MouseEvent) => {
      val userInput = userBox.getText
      val passInput = passBox.getText
      println(s"Username: $userInput | Password: $passInput")
      if(userInput == "admin" && passInput == "password") Main.setWindow("manager")
      else if(userInput == "floorstaff" && passInput == "password") Main.setWindow("floorstaff")
      else {
        failedLogin.setVisible(true)
      }
    }
  }

  val close: Button = new Button("Close") {
    relocate(210, 140)
    onMouseClicked = (e: MouseEvent) => {
      Main.mainStage.close()
    }
  }

  val failedLogin:Text = new Text("Invalid Username or Password") {
    relocate(115, 170)
    fill = Color.Red.brighter
    visible = false
  }



  def updateWindow: Unit = {
    // Refresh the page
    userBox.text = ""
    passBox.text = ""
  }


  content = List(titleText, userBox, passBox, loginConfirm, close, failedLogin)
}
