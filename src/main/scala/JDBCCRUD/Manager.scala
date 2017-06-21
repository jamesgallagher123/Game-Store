package JDBCCRUD

/**
  * Created by Profile on 20/06/2017.
  */
class Manager(managerID:Int, managerFullName: String, managerEmailAddress: String) extends Person{

  override var id: Int = managerID
  override var fullName: String = managerFullName
  override var emailAddress: String = managerEmailAddress

  override def toString: String = "Manager=> " + super.toString


}
