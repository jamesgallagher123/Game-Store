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

class DeleteEmployeeWindow extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))

  var deleteEmployee = new PersonCRUDOperation()

  val titleText: Text = new Text("Delete Employee") {
    relocate(55, 40)
    style = "-fx-font-size: 30pt"
    fill = Color.Black
  }

  val employee:ComboBox[String] = new ComboBox[String]() {
    relocate(120, 80)
    promptText = "Select Customers"
  }


  try {
    deleteEmployee.createDatabaseConenction()

    var preparedStatement = deleteEmployee.connection.prepareStatement(s"SELECT fullname FROM employees")

    var resultSet = preparedStatement.executeQuery()

    while (resultSet.next()){

      var getEmployeeName = resultSet.getString("fullname")
      employee.getItems.addAll(getEmployeeName)

    }

    println("Data Retrieved")
  } catch {
    case e: SQLException => e.printStackTrace()
  } finally {
    deleteEmployee.connection.close()
  }


  val fullName = new TextField() {
    relocate(120, 110)
    promptText = "Full Name"
  }

  val emailAddress = new TextField() {
    relocate(120, 140)
    promptText = "Email Address"
  }

  val loadDataBtn: Button = new Button("Load Data") {
    relocate(130, 170)
    onMouseClicked = (e: MouseEvent) => {

      try {
        deleteEmployee.createDatabaseConenction()

        var seletectedItem = employee.getValue

        var preparedStatement = deleteEmployee.connection.prepareStatement(s"SELECT customerid, fullname, emailaddress FROM employee WHERE fullname='$seletectedItem'")

        var resultSet = preparedStatement.executeQuery()

        if (resultSet.next()){

          val getCustomerName = resultSet.getString("fullname")
          val getCustomerEmail = resultSet.getString("emailaddress")
          val getCustomerID = resultSet.getString("customerid")

          fullName.setText(getCustomerName)
          emailAddress.setText(getCustomerEmail)
        }

        println("Data Retrieved")

      } catch {
        case e: SQLException => e.printStackTrace()
      } finally {
        deleteEmployee.connection.close()
      }

    }
  }

  val deleteEmployeeBtn: Button = new Button("Delete Employee") {
    relocate(130, 230)
    onMouseClicked = (e: MouseEvent) => {
      var getCustomerName = fullName.getText
      var getCustomerEmail = emailAddress.getText

    }
  }

  val back: Button = new Button("Back") {
    relocate(130, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("crudStaff")
    }
  }

  val failedLogin:Text = new Text("Unable to create customer") {
    relocate(170, 200)
    fill = Color.Red.brighter
    visible = false
  }

  def updateWindow: Unit = {
    // Refresh the page
    employee.setValue(null)
    fullName.text = ""
    emailAddress.text = ""
  }

  content = List(titleText, employee, fullName, emailAddress,loadDataBtn,deleteEmployeeBtn,back)
}