package pages

import BackEnd.Games

import scala.collection.mutable.ListBuffer
import scalafx.scene.Scene
import scalafx.scene.control.{Button, ListView}
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.Includes._

/**
  * Created by Administrator on 22/06/2017.
  */
class ViewGamesWindow extends Scene{
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

  // test data
  val games: ListBuffer[Games] = new ListBuffer()
  games += new Games(1, "Best Game", 5.99, 5, "20/06/2017")
  games += new Games(2, "Bad Game", 6.99, 5, "22/06/2017")

  val gameList:ListView[Games] = new ListView[Games](games.toList){
    relocate(0,0)
    prefWidth = 1000
  }

  gameList.onMouseClicked = (e:MouseEvent) => {
    println(gameList.selectionModel().getSelectedItem)
  }

  content = List(viewItemsTitle, gameList, backButton)
}

// gameList.items = new ListView[type](ListBuffer().toList).getItems
