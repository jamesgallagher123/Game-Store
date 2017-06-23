package pages.ManagerScreens

import BackEnd.FloorStaff
import pages.Main

import scala.collection.mutable.ListBuffer
import scalafx.scene.control.{Button, ListView}
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.Includes._
import scalafx.scene.Scene

/**
  * Created by Administrator on 23/06/2017.
  */
class ViewStaffWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var viewItemsTitle: Text = new Text(s"View Games") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }

  val backButton: Button = new Button("Back") {
    relocate(250, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("crudStaff")
    }
  }

  val staff: ListBuffer[FloorStaff] = new ListBuffer[FloorStaff]

  val staffList:ListView[FloorStaff] = new ListView[FloorStaff](staff.toList){
    relocate(0,0)
    prefWidth = 1000
  }

  content = List(viewItemsTitle, staffList, backButton)
}