package FrontEnd

/**
  * Created by Profile on 22/06/2017.
  */
import BackEnd.PersonCRUDOperation

import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.Includes._


class CreateEmployee extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))

  val titleText: Text = new Text("Create Employee") {
    relocate(55, 40)
    style = "-fx-font-size: 30pt"
    fill = Color.Black
  }

  val employeeType:ComboBox[String] = new ComboBox[String]() {
    relocate(120, 80)
    promptText = "Employee Type"

  }
  employeeType.getItems.addAll("Manager","Floor Staff")

  val fullName = new TextField() {
    relocate(120, 110)
    promptText = "Full Name"
  }

  val emailAddress = new TextField() {
    relocate(120, 140)
    promptText = "Email Address"
  }

  val createEmployeeBtn: Button = new Button("Create Employee") {
    relocate(130, 170)
    onMouseClicked = (e: MouseEvent) => {
      val getEmployeeType = employeeType.getValue
      val getFullName = fullName.getText
      val getEmailAddress = emailAddress.getText

      var test1 = new PersonCRUDOperation()

      if(test1.createEmployee(getEmployeeType,getFullName,getEmailAddress)=="Success"){
        println("Employee Created")
      }else{
        failedLogin.setVisible(true)
      }


      println(s"Employee Type: $getEmployeeType | Full Name: $getFullName | Email Address: $getEmailAddress")

    }
  }

  val failedLogin:Text = new Text("Unable to create customer") {
    relocate(170, 200)
    fill = Color.Red.brighter
    visible = false
  }

  def updateWindow: Unit = {
    // Refresh the page
    employeeType.setValue(null)
    fullName.text = ""
    emailAddress.text = ""
  }

  content = List(titleText, employeeType, fullName, emailAddress,createEmployeeBtn)
}
