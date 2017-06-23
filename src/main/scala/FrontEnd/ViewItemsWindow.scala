package FrontEnd

/**
  * Created by Profile on 22/06/2017.
  */

import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.Includes._

class ViewItemsWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var viewItemsTitle: Text = new Text(s"View Items") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }
  val backButton: Button = new Button("Back") {
    relocate(300, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("floorstaff")
    }
  }
  content = List(viewItemsTitle, backButton)
}