package BackEnd

/**
  * Created by Profile on 22/06/2017.
  */
object Test {

  def main(args: Array[String]): Unit = {

    var test1 = new PersonCRUDOperation()

    test1.addTest("Alex","Johnson")
    test1.addTest("Adam","Jackson")
    test1.addTest("Jack","Warnor")
    test1.addTest("Kyle","Davis")

    test1.abc()
  }
}
