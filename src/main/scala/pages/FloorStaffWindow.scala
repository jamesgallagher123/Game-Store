package pages

import pages.Main.setWindow

import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.paint.Color._
import scalafx.scene.text.Text

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
     setWindow("viewitems")
    }
  }

  val transactionsButton: Button = new Button("Transactions") {
    relocate(40, 120)
  }

  val customers: Button = new Button("Customers") {
    relocate(40, 170)
  }


    def updateWindow: Unit = {
      // Refresh the page
    }

  //move to selected option

        case
        case transactionsButton.onAction => setWindow("transactions")
        case customers.onAction => setWindow("customers")


    content = List(floorStaffTitle, viewItemsButton, transactionsButton, customers)
}
