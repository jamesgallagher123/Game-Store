package pages.ManagerScreens

import pages.Main

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
class CRUDStaffWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var crudStaffTitle: Text = new Text(s"CRUD Staff") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }

  val createButton: Button = new Button("Create Staff") {
    relocate(40, 80)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("")
    }
  }

  val readButton: Button = new Button("Read Staff") {
    relocate(40, 120)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("")
    }
  }

  val editButton: Button = new Button("Edit Staff") {
    relocate(40, 160)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("")
    }
  }

  val deleteButton: Button = new Button("Delete Staff") {
    relocate(40, 200)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("")
    }
  }

  val backButton: Button = new Button("Back") {
    relocate(250, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("crud")
    }
  }

  content = List(crudStaffTitle, createButton, readButton, editButton, deleteButton, backButton)
}
