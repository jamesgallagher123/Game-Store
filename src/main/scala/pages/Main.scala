package pages

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage

object Main extends JFXApp {
  var loginWindow:LoginWindow = new LoginWindow
  var mainStage:PrimaryStage = new PrimaryStage

  setWindow("login")
  // val close:Button = new Button("Close"){relocate(x, y))
  // close.onAction = (e:ActionEvent) => {}
  // import scalafx.Include._
  def setWindow(window:String): Unit = {
    window match {
      case "login" => mainStage.scene = loginWindow
        mainStage.width = 400
        mainStage.height = 350
      case _ => println("Window not valid")
    }
  }

}
