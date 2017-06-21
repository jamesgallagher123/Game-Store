package pages

import BackEnd.GameStore

import scalafx.Includes._
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.{Button, ComboBox, TextField}
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

class TransactionsWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  val gamestore = new GameStore
  var message = ""
  var quantity: Int = 0

  val transactionsTitle: Text = new Text(s"Make Transaction") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }
  val backButton: Button = new Button("Back") {
    relocate(300, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("floorstaff")
    }
  }

  val itemText: Text = new Text("Item Name:") {
    relocate(10, 115)
  }
  val itemName = new TextField() {
    relocate(120, 110)
  }

  val quantityText: Text = new Text("Amount purchased:") {
    relocate(10, 155)
  }
  val quantityPurchased = new ComboBox[Int]() {
    relocate(120, 150)
    items = ObservableBuffer(1,2,3,4,5,6,7,8,9,10)
  }

  val buyButton: Button = new Button("Buy") {
    relocate(120, 190)
    onMouseClicked = (e: MouseEvent) => {
      val item: String = itemName.toString()
      quantity = quantityPurchased.getValue
      message = gamestore.buyItem(item, quantity)
    }
  }

  val buyItemMessage: Text = new Text(message) {
    relocate(120, 240)
  }

  content = List(transactionsTitle, backButton, itemName, quantityPurchased, buyButton, buyItemMessage, itemText, quantityText)
}
