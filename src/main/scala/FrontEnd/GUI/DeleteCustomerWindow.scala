package pages

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


class DeleteCustomerWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))

  var deleteCustomer = new PersonCRUDOperation()
  var retrievedCustomerID = ""

  val titleText: Text = new Text("Delete Customers") {
    relocate(55, 40)
    style = "-fx-font-size: 30pt"
    fill = Color.Black
  }

  val customers:ComboBox[String] = new ComboBox[String]() {
    relocate(120, 80)
    promptText = "Select Customers"
  }


  try {
    deleteCustomer.createDatabaseConenction()

    var preparedStatement = deleteCustomer.connection.prepareStatement(s"SELECT fullname FROM customers")

    var resultSet = preparedStatement.executeQuery()

    while (resultSet.next()){

      var getCustomerName = resultSet.getString("fullname")
      customers.getItems.addAll(getCustomerName)

    }

    println("Data Retrieved")
  } catch {
    case e: SQLException => e.printStackTrace()
  } finally {
    deleteCustomer.connection.close()
  }


  val fullName = new TextField() {
    relocate(120, 110)
    promptText = "Full Name"
  }

  val emailAddress = new TextField() {
    relocate(120, 140)
    promptText = "Email Address"
  }

  val points = new TextField() {
    relocate(120, 170)
    promptText = "Points"
  }

  val loadDataBtn: Button = new Button("Load Data") {
    relocate(130, 200)
    onMouseClicked = (e: MouseEvent) => {

      try {
        deleteCustomer.createDatabaseConenction()

        var seletectedItem = customers.getValue

        var preparedStatement = deleteCustomer.connection.prepareStatement(s"SELECT customerid, fullname, emailaddress, points FROM customers WHERE fullname='$seletectedItem'")

        var resultSet = preparedStatement.executeQuery()

        if (resultSet.next()){

          val getCustomerName = resultSet.getString("fullname")
          val getCustomerEmail = resultSet.getString("emailaddress")
          val getCustomerPoints = resultSet.getString("points")
          val getCustomerID = resultSet.getString("customerid")

          fullName.setText(getCustomerName)
          emailAddress.setText(getCustomerEmail)
          points.setText(getCustomerPoints)
        }

        println("Data Retrieved")

        println(retrievedCustomerID)
      } catch {
        case e: SQLException => e.printStackTrace()
      } finally {
        deleteCustomer.connection.close()
      }

    }
  }

  val deleteEmployeeBtn: Button = new Button("Delete Employee") {
    relocate(130, 230)
    onMouseClicked = (e: MouseEvent) => {
      var getCustomerName = fullName.getText
      var getCustomerEmail = emailAddress.getText
      var getCustomerPoints = points.getText.toInt
      if(deleteCustomer.updateCustomerDetails(retrievedCustomerID.toInt,getCustomerName,getCustomerEmail,getCustomerPoints)=="Success"){
        println("Employee Deleted")
      }else{
        failedLogin.setVisible(true)
      }
    }
  }

  val back: Button = new Button("Back") {
    relocate(130, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("crudCustomers")
    }
  }

  val failedLogin:Text = new Text("Unable to create customer") {
    relocate(170, 200)
    fill = Color.Red.brighter
    visible = false
  }


  def updateWindow: Unit = {
    // Refresh the page
    customers.setValue(null)
    fullName.text = ""
    emailAddress.text = ""
  }

  content = List(titleText, customers, fullName, emailAddress,points,loadDataBtn,deleteEmployeeBtn,back)
}