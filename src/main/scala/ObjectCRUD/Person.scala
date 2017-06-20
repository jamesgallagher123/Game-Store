package ObjectCRUD

/**
  * Created by Profile on 20/06/2017.
  */
abstract class Person() {

  var id: Int
  var fullName: String
  var emailAddress: String

  override def toString: String = {s"Full Name: $fullName"}

}