package FrontEnd.GUI

import BackEnd.Hardware

import scala.collection.mutable.ListBuffer
import scalafx.scene.Scene
import scalafx.scene.control.{Button, ListView}
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.text.Text
import scalafx.Includes._

/**
  * Created by Administrator on 22/06/2017.
  */
class ViewHardwareWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var viewItemsTitle: Text = new Text(s"View Games") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }

  val backButton: Button = new Button("Back") {
    relocate(250, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("viewitems")
    }
  }

  val hardware: ListBuffer[Hardware] = new ListBuffer[Hardware]

  val hardwareList:ListView[Hardware] = new ListView[Hardware](hardware.toList){
    relocate(0,0)
    prefWidth = 1000
  }

  content = List(viewItemsTitle, hardwareList, backButton)
}
