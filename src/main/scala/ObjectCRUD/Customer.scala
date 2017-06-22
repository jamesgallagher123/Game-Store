package ObjectCRUD

/**
  * Created by Profile on 20/06/2017.
  */
class Customer(customerID:Int, customerFullName: String, customerEmailAddress: String) extends Person{

  override var id: Int = customerID
  override var fullName: String = customerFullName
  override var emailAddress: String = customerEmailAddress

  override def toString: String = "Customer=> " + super.toString


}