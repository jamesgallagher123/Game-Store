package pages

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

  val viewGamesButton: Button = new Button("View Games") {
    relocate(40, 80)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("viewGames")
    }
  }

  val viewHardwareButton: Button = new Button("View Hardware") {
    relocate(40, 120)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("viewHardware")
    }
  }

  val viewMiscButton: Button = new Button("View Misc") {
    relocate(40, 160)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("viewMisc")
    }
  }

  val backButton: Button = new Button("Back") {
    relocate(250, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("floorstaff")
    }
  }

  content = List(viewItemsTitle, viewGamesButton, viewHardwareButton, viewMiscButton, backButton)
}
