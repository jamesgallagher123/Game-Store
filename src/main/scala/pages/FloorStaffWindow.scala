package pages

import scalafx.Includes._
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color._
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.Includes._

class FloorStaffWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var floorStaffTitle: Text = new Text(s"Floorstaff Homepage") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }

  val viewItemsButton: Button = new Button("View Items") {
    relocate(40, 80)
    onMouseClicked =  (e: MouseEvent) => {
     Main.setWindow("viewitems")
    }
  }

  val transactionsButton: Button = new Button("Transactions") {
    relocate(40, 120)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("transactions")
    }
  }

  val customers: Button = new Button("Customers") {
    relocate(40, 170)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("customers")
    }
  }


    def updateWindow: Unit = {
      // Refresh the page
    }

  content = List(floorStaffTitle, viewItemsButton, transactionsButton, customers)
}
