package FrontEnd.GUI

/**
  * Created by Global InfoTech Dev on 23/06/2017.
  */
import java.sql.SQLException

import ObjectCRUD.PersonCRUDOperation

import scala.collection.mutable.ListBuffer
import scalafx.scene.Scene
import scalafx.scene.control.{Button, ComboBox, ListView, TextField}
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.Includes._


class DeleteItemWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))

  var deleteItem = new PersonCRUDOperation()
  var retrievedCustomerID = ""

  val titleText: Text = new Text("Delete Customers") {
    relocate(55, 40)
    style = "-fx-font-size: 30pt"
    fill = Color.Black
  }

  val itemname:ComboBox[String] = new ComboBox[String]() {
    relocate(120, 80)
    promptText = "Select Customers"
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

  val loadDataBtn: Button = new Button("Load Data") {
    relocate(130, 200)
    onMouseClicked = (e: MouseEvent) => {



    }
  }

  val deleteEmployeeBtn: Button = new Button("Delete Employee") {
    relocate(130, 230)
    onMouseClicked = (e: MouseEvent) => {
    }
  }

  val back: Button = new Button("Back") {
    relocate(130, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("crudItems")
    }
  }

  val failedLogin:Text = new Text("Unable to create customer") {
    relocate(170, 200)
    fill = Color.Red.brighter
    visible = false
  }

  def updateWindow: Unit = {
    // Refresh the page
    itemname.setValue(null)
    itemName.text = ""
    quantity.text = ""
    price.text = ""
  }

  content = List(titleText, itemname, itemName, quantity,price,loadDataBtn,deleteEmployeeBtn,back)
}
