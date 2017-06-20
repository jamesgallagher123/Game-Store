package ObjectCRUD

/**
  * Created by Profile on 20/06/2017.
  */
/**
  * Created by Profile on 20/06/2017.
  */

object Tester {

  def main(args: Array[String]): Unit = {

    var test1 = new PersonCRUDOperation()

    test1.createCustomer(new Customer(0, "John Clark", "jclark@hotmail.com"))
    test1.createCustomer(new Customer(1, "Alex Johnson", "ajohnson@hotmail.com"))
    test1.createCustomer(new Customer(2, "Adam Steaven", "asteaven@hotmail.com"))
    test1.createCustomer(new Customer(3, "Stuart Warner", "swarner@hotmail.com"))

    //test1.deleteCustomers()

    //test1.deleteCustomer("John Clark", "jclark@hotmail.com")
    test1.updateCustomer("Adam Steaven", "asteaven@hotmail.com", "Name Changed")


    test1.displayCustomers()
  }


}
