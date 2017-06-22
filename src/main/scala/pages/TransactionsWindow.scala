package pages

import BackEnd.{Customer, GameStore, Games, Hardware}

import scalafx.Includes._
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control._
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

class TransactionsWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  val gamestore = new GameStore
  var quantity: Int = 0
  var itemMessage: String = ""
  var points: Boolean = false
  val receiptItems1 = new Hardware(4321, "xbox one", 249.99, 1, "01/01/1901")
  val receiptItems2 = new Games(4321, "xbox game", 39.99, 5, "01/01/2001")
  gamestore.itemsListBuffer += receiptItems1
  gamestore.itemsListBuffer += receiptItems2
  val customer = new Customer(123, "Custo Mer", 1000)
  gamestore.customerListBuffer += customer


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

  val pointsText: Text = new Text("Paid with points:") {
    relocate(10, 75)
  }
  val payWithPoints = new ComboBox[String]() {
    relocate(120, 70)
    items = ObservableBuffer("yes", "no")
  }

  var dynamicLabelBuy = new Label("") {
    relocate(5, 260)
  }

  val customerIdText: Text = new Text("Customer Id:") {
    relocate(10, 195)
  }
  var customeridBox = new TextField() {
    relocate(120, 190)
  }

  val buyButton: Button = new Button("Buy") {
    relocate(120, 230)
    onMouseClicked = (e: MouseEvent) => {
      val item: String = itemName.getText
      val customer = customeridBox.getText.toInt
      quantity = quantityPurchased.getValue
      if (payWithPoints.getValue == "yes") points = true
      else points = false
      dynamicLabelBuy.text = gamestore.buyItem(item, quantity, points, customer)
    }
  }

  var dynamicLabelCheckout = new Label("") {
    relocate(5, 280)
  }

  val checkoutButton: Button = new Button("Checkout") {
    relocate(160, 230)
    onMouseClicked = (e: MouseEvent) => {
      val receiptData = gamestore.printReceipt(gamestore.checkout(), "Mr Floorstaff name", points, quantity)
      if (gamestore.checkout().items.isEmpty) dynamicLabelCheckout.text = "Cannot checkout no items purchased"
      if(gamestore.checkout().items.size < quantity) dynamicLabelCheckout.text
      else if (gamestore.checkout().items.nonEmpty) new Alert(AlertType.Information, receiptData).showAndWait()
    }
  }

  content = List(transactionsTitle, backButton, itemName, quantityPurchased, buyButton, itemText, quantityText, dynamicLabelBuy, checkoutButton, dynamicLabelCheckout, payWithPoints, pointsText, customerIdText, customeridBox)
}
