package ObjectCRUD

/**
  * Created by Profile on 20/06/2017.
  */
import scala.collection.mutable.ListBuffer

/**
  * Created by Profile on 20/06/2017.
  */

class PersonCRUDOperation {

  var customer:ListBuffer[Customer] = new ListBuffer[Customer]()
  var floorStaff:ListBuffer[FloorStaff] = new ListBuffer[FloorStaff]()
  var manager:ListBuffer[Manager] = new ListBuffer[Manager]()




  def createCustomer(insertCustomer:Customer): Unit ={
    customer += insertCustomer;
  }

  def createFloorStaff(insertFloorStaff:FloorStaff): Unit={
    floorStaff += insertFloorStaff
  }

  def createManager(insertManager:Manager): Unit ={
    manager += insertManager;
  }




  def deleteCustomer(customerName: String, customerEmail: String): Unit ={
    customer.map(item=>if(item.fullName == customerName && item.emailAddress == customerEmail){customer.remove(item.id)})
  }

  def deleteFloorStaff(floorStaffName: String, floorStaffEmail: String): Unit ={
    floorStaff.map(item=>if(item.fullName == floorStaffName && item.emailAddress == floorStaffEmail){floorStaff.remove(item.id)})
  }

  def deleteManager(managerFullName: String, managerEmail: String): Unit ={

    manager --= manager.filter(item=>(item.fullName == managerFullName && item.emailAddress == managerEmail))

  }




  def updateCustomer(cFullName: String, cEmail: String, cUpdateData:String)={
    customer.foreach(item=>if(item.fullName == cFullName && item.emailAddress== cEmail){customer.updated(item.id,item.fullName=cUpdateData)})
  }

  def updateFloorStaff(fFullName: String, fEmail: String, fUpdateData:String)={
    floorStaff.foreach(item=>if(item.fullName == fFullName && item.emailAddress== fEmail){floorStaff.updated(item.id,item.fullName=fUpdateData)})
  }


  def updateManager(mFullName: String, mEmail: String, mUpdateData:String)={
    manager.foreach(item=>if(item.fullName == mFullName && item.emailAddress== mEmail){manager.updated(item.id,item.fullName=mUpdateData)})
  }




  def displayCustomers(): Unit ={
    customer.foreach(item=>println(item))
  }

  def displayFloorStaff(): Unit ={
    floorStaff.foreach(item=>println(item))
  }

  def displayManager(): Unit ={
    manager.foreach(item=>println(item))
  }

}
