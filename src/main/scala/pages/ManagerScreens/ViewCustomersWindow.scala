package pages.ManagerScreens

import BackEnd.Customer
import pages.Main
import pages.Main.gameStore

import scala.collection.mutable.ListBuffer
import scalafx.scene.control.{Button, ListView}
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color.{DarkGray, LightGray}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.Includes._
import scalafx.scene.Scene

/**
  * Created by Administrator on 23/06/2017.
  */
class ViewCustomersWindow extends Scene{
  fill = new LinearGradient(endX = 0, stops = Stops(LightGray.brighter, DarkGray))
  var viewItemsTitle: Text = new Text(s"View Games") {
    relocate(40, 40)
    style = "-fx-font-size: 25pt"
    fill = Color.Black
  }

  val backButton: Button = new Button("Back") {
    relocate(250, 260)
    onMouseClicked = (e: MouseEvent) => {
      Main.setWindow("crudCustomers")
    }
  }

  //val customer: ListBuffer[Customer] = Main.gameStore.customerListBuffer
  val cListBuffer: ListBuffer[Customer] = new ListBuffer[Customer]
  val customer1 = new Customer(123, "Custo Mer 1", "cust.omer@hotmail.com", 1000)
  val customer2 = new Customer(134, "Custo Mer 2", "cust.omer@hotmail.com", 500)
  val customer3 = new Customer(156, "Custo Mer 3","cust.omer@hotmail.com", 0)
  cListBuffer += customer1
  cListBuffer += customer2
  cListBuffer += customer3
  

  val customerList:ListView[Customer] = new ListView[Customer](cListBuffer.toList){
    relocate(0,0)
    prefWidth = 1000
  }

  content = List(viewItemsTitle, customerList, backButton)
}
