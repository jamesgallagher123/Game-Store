package JDBCCRUD

/**
  * Created by Profile on 20/06/2017.
  */
import java.sql

import scala.collection.mutable.ListBuffer
import java.sql.{Connection, DriverManager}

/**
  * Created by Profile on 20/06/2017.
  */

class PersonCRUDOperation {

  var connection:sql.Connection = _

  var customer:ListBuffer[Customer] = new ListBuffer[Customer]()
  var floorStaff:ListBuffer[FloorStaff] = new ListBuffer[FloorStaff]()
  var manager:ListBuffer[Manager] = new ListBuffer[Manager]()

  def createDatabaseConenction(): Unit ={

    var test1 = new PersonCRUDOperation()
    val url = "jdbc:mysql://localhost:3306/GameStore"
    val driver = "com.mysql.jdbc.Driver"
    val username = "root"
    val password = "root"

    try{

      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
      println("Successfully connected to the databse")

    }catch{
      case e: Exception => e.printStackTrace
    }

  }

  def createUser(userType: String, username: String, password: String): Unit ={

    createDatabaseConenction()

    val statement = connection.createStatement()
    val resultSet = statement.executeUpdate(s"INSERT INTO registeredusers (Type,Username,Password) VALUES('$userType','$username','$password')")

    println(s"User: $username has been registered successfully")

    connection.close()
  }

  def updateUser(findUser:String,newUserType: String, newUsername: String, newPassword: String): Unit={

    createDatabaseConenction()

    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(s"SELECT Username FROM registeredusers WHERE( Username ='$findUser')")

    while(resultSet.next()){

      //var getUserType = resultSet.getString("Type")
      var getUser = resultSet.getString("Username")
      var getPass = resultSet.getString("Password")

      //.updateString("Type", getUserType.toUpperCase)
      resultSet.updateString("Username", getUser.toUpperCase)
      resultSet.updateString("Password", getPass.toUpperCase)

      resultSet.rowUpdated()

    }

    println(s"User: $findUser has been registered successfully")

    connection.close()

  }


}
