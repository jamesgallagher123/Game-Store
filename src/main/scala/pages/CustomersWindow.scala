package pages

import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.Includes._

class CustomersWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var customerTitle: Text = new Text("Customer") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }

  val createButton: Button = new Button("Create Customers") {
    relocate(40, 80)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("floorStaffCreateCustomer")
    }
  }

  val readButton: Button = new Button("Read Customers") {
    relocate(40, 120)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("floorStaffReadCustomer")
    }
  }

  val editButton: Button = new Button("Edit Customers") {
    relocate(40, 160)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("floorStaffEditCustomer")
    }
  }

  val deleteButton: Button = new Button("Delete Customers") {
    relocate(40, 200)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("floorStaffDeleteCustomer")
    }
  }

  val backButton: Button = new Button("Back") {
    relocate(300, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("floorstaff")
    }
  }
  content = List(customerTitle, createButton, readButton, editButton, deleteButton, backButton)
}