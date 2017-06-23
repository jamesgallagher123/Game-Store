package JDBCCRUD

/**
  * Created by Profile on 20/06/2017.
  */
import java.sql

import scala.collection.mutable.ListBuffer
import java.sql.{SQLException, _}

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


  def createUser(userType:String, username:String, password:String): Unit ={

    try{
      createDatabaseConenction()

      var preparedStatement = connection.prepareStatement(s"INSERT INTO registeredusers (Type,Username,Password) VALUES('$userType','$username','$password')")

      preparedStatement.executeUpdate()

      println(s"$username has been registered successfully")

    }catch{
      case e: SQLException => e.printStackTrace()
    }finally {
      connection.close()
    }

  }






  def updateUser(findUser:String,newUserType: String, newUsername: String, newPassword: String): Unit={

    try{
      createDatabaseConenction()

      //var preparedStatement = connection.prepareStatement(s"UPDATE registeredusers SET type='$newUserType', username='$newUsername', password='$newPassword' WHERE username = '$findUser'")

      //preparedStatement.executeUpdate()

      var preparedStatement = connection.prepareStatement(s"SELECT * FROM registeredusers WHERE username='$findUser'")

      var resultSet = preparedStatement.executeQuery()

      if(resultSet.next()){

        var getUserType:String = resultSet.getString(2)
        var getUsername:String = resultSet.getString(3)
        var getUserPassword:String = resultSet.getString(4)

        //resultSet.updateString(2, s"$newUserType")

        //resultSet.updateRow()

        println(s"$getUserType, $getUsername, $getUserPassword")


      }else{
        println("Record does not exist. You can proceed")
      }

      //println(s"$findUser has been updated successfully")

    }catch{
      case e: SQLException => e.printStackTrace()
    }finally {
      connection.close()
    }

  }


  def verifyLogin(username:String,password: String): Unit= {

    var result = ""

    try{
      createDatabaseConenction()

      var preparedStatement = connection.prepareStatement(s"SELECT * FROM registeredusers WHERE username='$username', password='$password'")

      var resultSet = preparedStatement.executeQuery()

      if(resultSet.next()){

        var getUserType:String = resultSet.getString(2)
        var getUsername:String = resultSet.getString(3)
        var getUserPassword:String = resultSet.getString(4)

        println("User Found")

      }else{
        println("Record does not exist.")
      }

      //println(s"$findUser has been updated successfully")

    }catch{
      case e: SQLException => e.printStackTrace()
    }finally {
      connection.close()
    }

  }


}
