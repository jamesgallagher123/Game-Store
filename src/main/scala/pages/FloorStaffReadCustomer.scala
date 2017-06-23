package pages

import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.Includes._

/**
  * Created by Administrator on 23/06/2017.
  */
class FloorStaffReadCustomer extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var customerTitle: Text = new Text("Read Customers") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }
  val backButton: Button = new Button("Back") {
    relocate(300, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("customers")
    }
  }

  content = List(customerTitle, backButton)
}
