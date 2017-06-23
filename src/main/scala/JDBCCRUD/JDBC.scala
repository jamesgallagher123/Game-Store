package JDBCCRUD


/**
  * Created by Profile on 20/06/2017.
  */
object JDBC {

  def main(args: Array[String]) {

    var personCRUD = new PersonCRUDOperation()

    //personCRUD.createUser("Admin", "New Admin", "newadmin")

    personCRUD.updateUser("Staff","New User Type","Admin1","Admin1pass")
    personCRUD.verifyLogin("abc","abc")

  }

}

