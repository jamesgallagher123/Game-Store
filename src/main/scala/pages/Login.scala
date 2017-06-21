package pages

import scalafx.Includes._
import scalafx.application.{JFXApp, Platform}
import scalafx.geometry.Insets
import scalafx.scene.control.ButtonBar.ButtonData
import scalafx.scene.control._
import scalafx.scene.layout.GridPane

// From https://codingonthestaircase.wordpress.com/2015/03/18/scalafx-alerts-and-dialogs/
object Login extends JFXApp {

  case class Result(username: String, password: String)

  // Create the custom dialog.
  val dialog = new Dialog[Result]() {
    initOwner(stage)
    title = "Login Dialog"
    headerText = "Look, a Custom Login Dialog"
  }

  // Set the button types.
  val loginButtonType = new ButtonType("Login", ButtonData.OKDone)
  dialog.dialogPane().buttonTypes = Seq(loginButtonType, ButtonType.Cancel)

  // Create the username and password labels and fields.
  val username = new TextField() {
    promptText = "Username"
  }
  val password = new PasswordField() {
    promptText = "Password"
  }

  val grid = new GridPane() {
    hgap = 10
    vgap = 10
    padding = Insets(20, 100, 10, 10)

    add(new Label("Username:"), 0, 0)
    add(username, 1, 0)
    add(new Label("Password:"), 0, 1)
    add(password, 1, 1)
  }

  // Enable/Disable login button depending on whether a username was entered.
  val loginButton = dialog.dialogPane().lookupButton(loginButtonType)
  loginButton.disable = true

  // Do some validation (disable when username is empty).
  username.text.onChange { (_, _, newValue) =>
    loginButton.disable = newValue.trim().isEmpty
  }

  dialog.dialogPane().content = grid

  // Request focus on the username field by default.
  Platform.runLater(username.requestFocus())

  // When the login button is clicked, convert the result to a username-password-pair.
  dialog.resultConverter = dialogButton =>
    if (dialogButton == loginButtonType) Result(username.text(), password.text())
    else null

  val result = dialog.showAndWait()

  result match {
    case Some(Result(u, p)) if u=="admin" && p=="password" => println("Username=" + "admin" + ", Password=" + "password")
    case Some(Result(u, p)) if u=="floor" && p=="password" => println("Username=" + "floor" + ", Password=" + "password")
    case _ => println("Invalid login")
  }


}