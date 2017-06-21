package ObjectCRUD

/**
  * Created by Profile on 20/06/2017.
  */
class FloorStaff(floorStaffID:Int, floorStaffFullName: String, floorStaffEmailAddress: String) extends Person{

  override var id: Int = floorStaffID
  override var fullName: String = floorStaffFullName
  override var emailAddress: String = floorStaffEmailAddress

  override def toString: String = "Floor Staff=> " + super.toString


}