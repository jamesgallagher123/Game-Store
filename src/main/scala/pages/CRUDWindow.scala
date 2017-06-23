package pages

import scalafx.Includes._
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

/**
  * Created by Administrator on 22/06/2017.
  */
class CRUDWindow extends Scene{
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var crudTitle: Text = new Text(s"CRUD") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }

  val crudItemsButton: Button = new Button("CRUD Items") {
    relocate(40, 80)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("crudItems")
    }
  }

  val crudCustomersButton: Button = new Button("CRUD Customers") {
    relocate(40, 120)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("crudCustomers")
    }
  }

  val crudStaffButton: Button = new Button("CRUD Staff") {
    relocate(40, 160)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("crudStaff")
    }
  }

  val backButton: Button = new Button("Back") {
    relocate(250, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("manager")
    }
  }

  content = List(crudTitle, crudItemsButton, crudCustomersButton, crudStaffButton, backButton)
}