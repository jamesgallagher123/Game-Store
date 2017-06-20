/**
  * Created by Administrator on 20/06/2017.
  */
object TestItemCRUD {

  def main(args: Array[String]): Unit = {

  var test1 = new ItemCRUDOperation ()

    test1.createHardware(new Hardware(0, "Laptop", 350.00, 2))
    test1.createHardware(new Hardware(1, "Console", 200.00, 3))
    test1.createHardware(new Hardware(2, "phone", 90.00, 4))

    test1.readHardware ()

  }

}
