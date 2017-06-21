package pages

import scalafx.scene.Scene
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

class TransactionsWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var transactionsTitle: Text = new Text(s"Make Transaction") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }
}
