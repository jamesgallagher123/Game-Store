package pages

import scalafx.Includes._
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.input.MouseEvent
import scalafx.scene.control.Button
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.paint.Color._
import scalafx.scene.text.Text
import scalafx.Includes._
import scalafx.scene.input.MouseEvent
import pages.LoginWindow

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
      Main.setWindow("transactions")
    }
  }

  val repandrecButton: Button = new Button("Reports & Receipts") {
    relocate(40, 160)
    onMouseClicked =  (e: MouseEvent) => {
      Main.setWindow("repandrec")
    }
  }

  val logoutButton: Button = new Button("Log Out") {
    relocate(250, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("login")
    }
  }

  def updateWindow: Unit = {
    // Refresh the page
  }

  content = List(managerTitle, crudButton, transactionsButton, repandrecButton, logoutButton)

}
