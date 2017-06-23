package pages.ManagerScreens

import BackEnd.Miscellaneous
import pages.Main

import scala.collection.mutable.ListBuffer
import scalafx.Includes._
import scalafx.scene.Scene
import scalafx.scene.control.{Button, ListView}
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

/**
  * Created by Administrator on 22/06/2017.
  */
class ViewMiscWindow extends Scene{
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var viewItemsTitle: Text = new Text(s"View Games") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }

  val backButton: Button = new Button("Back") {
    relocate(250, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("viewItemsManager")
    }
  }

  val misc: ListBuffer[Miscellaneous] = new ListBuffer[Miscellaneous]

  val miscList:ListView[Miscellaneous] = new ListView[Miscellaneous](misc.toList){
    relocate(0,0)
    prefWidth = 1000
  }

  content = List(viewItemsTitle, miscList, backButton)
}
