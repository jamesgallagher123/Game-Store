/**
  * Created by Administrator on 20/06/2017.
  */

import sun.plugin2.message.GetAppletMessage

import scala.collection.mutable.ListBuffer


class ItemCRUDOperation {

  var hardware: ListBuffer[Hardware] = new ListBuffer[Hardware]()
  var games: ListBuffer[Games] = new ListBuffer[Games]()
  var miscellaneous: ListBuffer[Miscellaneous] = new ListBuffer[Miscellaneous]()

  def createHardware(insertHardware: Hardware) {
    hardware += insertHardware
  }

  def createGames(insertGames: Games) {
    games += insertGames
  }

  def createMiscellaneous(insertMiscellaneous: Miscellaneous) {
    miscellaneous += insertMiscellaneous
  }

  def readHardware(): Unit = {
    hardware.foreach(item=>println(item))
  }

  def readGames(): Unit = {
    games.foreach(item=>println(item))
  }

  def readMiscellaneous(): Unit = {
    miscellaneous.foreach(item=>println(item))
  }

  def updateHardware (hardwareName:String, newData:String): Unit = {
    hardware.map(item=> if (item.name == hardwareName) {hardware.updated(item.id, item.name = newData)} )
  }

  def updateGames (gamesName:String, newData:String): Unit = {
    games.map(item=> if (item.name == gamesName) {games.updated(item.id, item.name = newData)} )
  }

  def updateMicellaneous (miscellaneousName:String, newData:String): Unit = {
    miscellaneous.map(item=> if (item.name == miscellaneousName) {miscellaneous.updated(item.id, item.name = newData)} )
  }

  def deleteHardware (hardwareName:String): Unit = {
  hardware.map(item => if (hardwareName == item.name) hardware -= item)
  }

  def deleteGames (gamesName:String): Unit = {
  games.map(item=> if (gamesName == item.name) games -= item)
  }

  def deleteMiscellaneous (miscellaneousName:String): Unit = {
  miscellaneous.map(item => if (miscellaneousName == item.name) miscellaneous -= item)
  }
}
