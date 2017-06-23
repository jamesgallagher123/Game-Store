package FrontEnd

/**
  * Created by Profile on 22/06/2017.
  */
import BackEnd.Games
import pages.Main

import scalafx.Includes._
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color._
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

class ViewProfits extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))

  var managerTitle: Text = new Text(s"Profits") {
    relocate(140, 40)
    style = "-fx-font-size: 30pt"
    fill = Color.Black
  }

  val label: Label = new Label("") {
    relocate(100, 160)
  }


  val profitsCombo: ComboBox[String] = new ComboBox[String]() {
    relocate(100, 100)
    promptText = "Select:"
    items = ObservableBuffer("View Reports", "View Receipts")
  }

  val button: Button = new Button("Select") {
    relocate(225,100)
    onMouseClicked = (e: MouseEvent) => {
      var result = profitsCombo.getValue
      if(result == "View Reports") {
        val currentDate = Main.gameStore.getCurrentDate
        val todayProfit = Main.gameStore.getDaysProfit(currentDate)
        val tomorrowProfit = Main.gameStore.expectedProfit
        label.text =
          s"Date: $currentDate\n" +
            s"Today's Profit: £$todayProfit\n" +
            s"Tomorrow's Expected Profit: £$tomorrowProfit"
      }
      else if(result == "View Receipts") {

      }
      else println(null)
    }
  }

  def updateWindow: Unit = {
    // Refresh the page
  }

  content = List(managerTitle, profitsCombo, label, button)

}