package FrontEnd.GUI


import ObjectCRUD.PersonCRUDOperation

import scalafx.scene.Scene
import scalafx.scene.control.{Button, TextField}
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.Includes._

class CreateCustomer extends Scene {
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))

  val titleText: Text = new Text("Create Customer") {
    relocate(55, 40)
    style = "-fx-font-size: 30pt"
    fill = Color.Black
  }

  val fullName = new TextField() {
    relocate(120, 80)
    promptText = "Full Name"
  }

  val emailAddress = new TextField() {
    relocate(120, 110)
    promptText = "Email Address"
  }

  val points = new TextField() {
    relocate(120, 140)
    promptText = "Points"
  }

  val createCustomerConfirm: Button = new Button("Create Customer") {
    relocate(130, 170)
    onMouseClicked = (e: MouseEvent) => {
      val getFullName = fullName.getText
      val getEmailAddress = emailAddress.getText
      val getPoints = points.getText

      println(s"Customer Name: $getFullName | Email Address: $getEmailAddress | Points: $getPoints")


      var test1 = new PersonCRUDOperation()



    }
  }

  val back: Button = new Button("Back") {
    relocate(130, 200)
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
    fullName.text = ""
    emailAddress.text = ""
    points.text = ""
  }

  content = List(titleText, fullName, emailAddress, points, createCustomerConfirm, back)
}
