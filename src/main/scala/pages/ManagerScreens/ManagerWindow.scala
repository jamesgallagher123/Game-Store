package pages.ManagerScreens

import pages.Main

import scalafx.Includes._
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color._
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

/**
  * Created by Profile on 21/06/2017.
  */
class ManagerWindow extends Scene{

  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var managerTitle: Text = new Text(s"Manager Homepage") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }

  val crudButton: Button = new Button("CRUD Operations") {
    relocate(40, 80)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("crud")
    }
  }

  val transactionsButton: Button = new Button("Transactions") {
    relocate(40, 120)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("transactionsmanager")
    }
  }

  val repandrecButton: Button = new Button("Reports & Receipts") {
    relocate(40, 160)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("profits")
    }
  }

  val logoutButton: Button = new Button("Log Out") {
    relocate(260, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("login")
    }
  }

  def updateWindow: Unit = {
    // Refresh the page
  }

  content = List(managerTitle, crudButton, transactionsButton, repandrecButton, logoutButton)

}
