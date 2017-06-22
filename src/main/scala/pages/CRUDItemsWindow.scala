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
class CRUDItemsWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var crudCItemsTitle: Text = new Text(s"CRUD Items") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }

  val createButton: Button = new Button("Create Items") {
    relocate(40, 80)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("crud")
    }
  }

  val readButton: Button = new Button("Read Items") {
    relocate(40, 120)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("transactions")
    }
  }

  val editButton: Button = new Button("Edit Items") {
    relocate(40, 160)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("repandrec")
    }
  }

  val deleteButton: Button = new Button("Delete Items") {
    relocate(40, 200)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("repandrec")
    }
  }

  val backButton: Button = new Button("Back") {
    relocate(250, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("crud")
    }
  }

  content = List(crudCItemsTitle, createButton, readButton, editButton, deleteButton, backButton)
}
