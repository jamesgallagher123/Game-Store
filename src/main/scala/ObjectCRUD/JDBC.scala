package ObjectCRUD

import java.sql.{Connection, DriverManager}

/**
  * Created by Profile on 20/06/2017.
  */
object JDBC {

  def main(args: Array[String]) {
    // connect to the database named "mysql" on the localhost
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://globalinfotechsolutions.co.uk/globalinfotech_gamestore"
    val username = "globalinfotech_gamestoreadmin"
    val password = "gamestore2017"

    // there's probably a better way to do this
    var connection:Connection = null

    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      println("Successful")

    } catch {
      case e => e.printStackTrace
    }
    connection.close()
  }


}
