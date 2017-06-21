package pages

import scalafx.scene.Scene
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

class ViewItemsWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var viewItemsTitle: Text = new Text(s"View Items") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }
}
