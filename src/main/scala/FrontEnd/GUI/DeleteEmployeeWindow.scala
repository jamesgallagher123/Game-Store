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