package JavaSwinfFrontEnd

/**
  * Created by Global InfoTech Dev on 22/06/2017.
  */
import javax.swing._
import java.awt._
import java.awt.event._
import javax.swing.border._

import ObjectCRUD.PersonCRUDOperation

class CreateCustomer extends JFrame{

  val btnCreateCutomer = new JButton("Login")
  val btnMainMenu = new JButton("Main Menu")

  val txtFullName = new JTextField()
  val txtEmailAddress = new JTextField()
  val txtPoints = new JTextField()

  def createCustomerGUI(): Unit ={

    var jPanel = new JPanel()

    setTitle("Create Customer")
    setSize(680,280)
    setLocation(600,280)
    jPanel.setLayout(null)

    val lblMsgLabel = new JLabel("Create Customer")
    lblMsgLabel.setBounds(178,30,360,27)
    lblMsgLabel.setBorder(LineBorder.createBlackLineBorder)
    lblMsgLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    lblMsgLabel.setForeground(Color.WHITE)
    lblMsgLabel.setBackground(Color.BLUE)
    lblMsgLabel.setOpaque(true)

    val lblFullName = new JLabel("Full Name")
    lblFullName.setBounds(20, 100, 290, 27)
    lblFullName.setBorder(LineBorder.createBlackLineBorder)
    lblFullName.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    lblFullName.setForeground(Color.WHITE)
    lblFullName.setBackground(Color.BLUE)
    lblFullName.setOpaque(true)

    txtFullName.setBounds(360,100,290,27)
    txtFullName.setBorder(LineBorder.createBlackLineBorder)
    txtFullName.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    txtFullName.setForeground(Color.GREEN)
    txtFullName.setBackground(Color.GRAY)
    txtFullName.setOpaque(true)

    val lblEmailAddress = new JLabel("Email Address")
    lblEmailAddress.setBounds(20,140,290,27)
    lblEmailAddress.setBorder(LineBorder.createBlackLineBorder)
    lblEmailAddress.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    lblEmailAddress.setForeground(Color.WHITE)
    lblEmailAddress.setBackground(Color.BLUE)
    lblEmailAddress.setOpaque(true)


    txtEmailAddress.setBounds(360,140,290,27)
    txtEmailAddress.setBorder(LineBorder.createBlackLineBorder)
    txtEmailAddress.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    txtEmailAddress.setForeground(Color.GREEN)
    txtEmailAddress.setBackground(Color.GRAY)
    txtEmailAddress.setOpaque(true)


    val lblPoints = new JLabel("Points")
    lblPoints.setBounds(20,180,290,27)
    lblPoints.setBorder(LineBorder.createBlackLineBorder)
    lblPoints.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    lblPoints.setForeground(Color.WHITE)
    lblPoints.setBackground(Color.BLUE)
    lblPoints.setOpaque(true)

    txtPoints.setBounds(360,180,290,27)
    txtPoints.setBorder(LineBorder.createBlackLineBorder)
    txtPoints.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    txtPoints.setForeground(Color.GREEN)
    txtPoints.setBackground(Color.GRAY)
    txtPoints.setOpaque(true)

    btnCreateCutomer.setBounds(360,220,290,27)
    btnCreateCutomer.setBorder(LineBorder.createBlackLineBorder)
    btnCreateCutomer.setFont(new Font("Bookman Old Style", Font.BOLD, 18))

    btnMainMenu.setBounds(360,260,290,27)
    btnMainMenu.setBorder(LineBorder.createBlackLineBorder)
    btnMainMenu.setFont(new Font("Bookman Old Style", Font.BOLD, 18))

    jPanel.add(lblMsgLabel)
    jPanel.add(lblFullName)
    jPanel.add(txtFullName)
    jPanel.add(lblEmailAddress)
    jPanel.add(txtEmailAddress)
    jPanel.add(lblPoints)
    jPanel.add(txtPoints)
    jPanel.add(btnCreateCutomer)
    jPanel.add(btnMainMenu)

    getContentPane.add(jPanel)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setVisible(true)

    createNewCustomer()

  }

  def createNewCustomer(): Unit ={

    btnCreateCutomer.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {

        var test1 = new PersonCRUDOperation()


      }
    })
  }

}

object CreateCustomerArea{
  def main(args: Array[String]): Unit = {
    val createCustomer = new CreateCustomer()
    createCustomer.createCustomerGUI()
  }
}
