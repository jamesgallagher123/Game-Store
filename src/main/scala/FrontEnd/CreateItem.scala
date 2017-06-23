package FrontEnd

/**
  * Created by Profile on 22/06/2017.
  */
import BackEnd.PersonCRUDOperation

import scalafx.scene.Scene
import scalafx.scene.control.{Button, TextField}
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.Includes._

class CreateItem extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))

  val titleText: Text = new Text("Create Item") {
    relocate(55, 40)
    style = "-fx-font-size: 30pt"
    fill = Color.Black
  }

  val itemType = new TextField() {
    relocate(120, 80)
    promptText = "Item Type"
  }

  val itemName = new TextField() {
    relocate(120, 110)
    promptText = "Item Name"
  }

  val quantity = new TextField() {
    relocate(120, 140)
    promptText = "Quantity"
  }

  val price = new TextField() {
    relocate(120, 170)
    promptText = "Price"
  }

  val createItemBtn: Button = new Button("Create Item") {
    relocate(130, 200)
    onMouseClicked = (e: MouseEvent) => {
      val getItemType = itemType.getText
      val getItemName = itemName.getText
      val getQuantity = quantity.getText
      val getPrice = price.getText

      println(s"Item Type: $getItemType | Item Name: $getItemName | Quantity: $getQuantity | Price: $getPrice")


      var test1 = new PersonCRUDOperation()

      if(test1.createItem(getItemType,getItemName,getQuantity.toInt,getPrice.toDouble)=="Success"){
        println("Item Created")
      }else{
        failedLogin.setVisible(true)
      }


    }
  }

  val failedLogin:Text = new Text("Unable to create customer") {
    relocate(170, 200)
    fill = Color.Red.brighter
    visible = false
  }

  def updateWindow: Unit = {
    // Refresh the page
    itemType.text=""
    itemName.text = ""
    quantity.text = ""
    price.text = ""
  }

  content = List(titleText, itemType, itemName, quantity, price, createItemBtn)
}