package pages

/**
  * Created by Global InfoTech Dev on 23/06/2017.
  */
import java.sql.SQLException

import BackEnd.{Customer, Games, PersonCRUDOperation}

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


  try {
    deleteItem.createDatabaseConenction()

    var preparedStatement = deleteItem.connection.prepareStatement(s"SELECT name FROM items")

    var resultSet = preparedStatement.executeQuery()

    while (resultSet.next()){

      var getCustomerName = resultSet.getString("name")
      itemname.getItems.addAll(getCustomerName)

    }

    println("Data Retrieved")
  } catch {
    case e: SQLException => e.printStackTrace()
  } finally {
    deleteItem.connection.close()
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

      try {
        deleteItem.createDatabaseConenction()

        var seletectedItem = itemname.getValue

        var preparedStatement = deleteItem.connection.prepareStatement(s"SELECT customerid, fullname, emailaddress, points FROM customers WHERE fullname='$seletectedItem'")

        var resultSet = preparedStatement.executeQuery()

        if (resultSet.next()){

          val getCustomerName = resultSet.getString("fullname")
          val getCustomerEmail = resultSet.getString("emailaddress")
          val getCustomerPoints = resultSet.getString("points")
          val getCustomerID = resultSet.getString("customerid")

          itemName.setText(getCustomerName)
          quantity.setText(getCustomerEmail)
          price.setText(getCustomerPoints)
        }

        println("Data Retrieved")

        println(retrievedCustomerID)
      } catch {
        case e: SQLException => e.printStackTrace()
      } finally {
        deleteItem.connection.close()
      }

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
