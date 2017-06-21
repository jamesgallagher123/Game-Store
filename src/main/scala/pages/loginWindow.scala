package pages

import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.text.Text

/**
  * Created by Administrator on 21/06/2017.
  */
class LoginWindow extends Scene{
  var test:Text = new Text("Login"){
    relocate(160,30)
    style = "-fx-font-size: 20pt"
  }
  fill = Color.LightGray
  //ComboBox - Dropdown list new ComboBox][Type](List())
  //var combo:ComboBox[String] = new ComboBox[String]("First option", "Second Option")
  //combo.getSelectionModel().getSelected.value
  //TextField - editable
  //TextArea
  //PromptText
  //ListView
  def updateWindow: Unit = {
    // Refresh the page
  }
  Main.setWindow("ManagerWindow")
  content = List(test)
}
