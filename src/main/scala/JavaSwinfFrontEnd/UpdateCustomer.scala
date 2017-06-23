package JavaSwinfFrontEnd

/**
  * Created by Profile on 22/06/2017.
  */
import javax.swing._
import java.awt._
import java.awt.event._
import javax.swing.border._

import ObjectCRUD.PersonCRUDOperation


class UpdateCustomer extends JFrame{

  val btnFindCustomerDetails = new JButton("Find Customer Details")
  val btnUpdateCustomer = new JButton("Update Customer")
  val btnMainMenu = new JButton("Main Menu")

  val txtFullName = new JTextField()
  val txtEmailAddress = new JTextField()

  val cmbCustomerName = new JComboBox[String]()

  def updateCustomerGUI(): Unit ={

    var jPanel = new JPanel()

    setTitle("Update Customer")
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

    val lblFindCustomer = new JLabel("Find Customer")
    lblFindCustomer.setBounds(20, 100, 290, 27)
    lblFindCustomer.setBorder(LineBorder.createBlackLineBorder)
    lblFindCustomer.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    lblFindCustomer.setForeground(Color.WHITE)
    lblFindCustomer.setBackground(Color.BLUE)
    lblFindCustomer.setOpaque(true)


    cmbCustomerName.setBounds(360,100,290,27)
    cmbCustomerName.setBorder(LineBorder.createBlackLineBorder)
    cmbCustomerName.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    cmbCustomerName.setForeground(Color.GREEN)
    cmbCustomerName.setBackground(Color.GRAY)
    cmbCustomerName.setOpaque(true)


    val lblFullName = new JLabel("Full Name")
    lblFullName.setBounds(20,140,290,27)
    lblFullName.setBorder(LineBorder.createBlackLineBorder)
    lblFullName.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    lblFullName.setForeground(Color.WHITE)
    lblFullName.setBackground(Color.BLUE)
    lblFullName.setOpaque(true)


    txtFullName.setBounds(360,140,290,27)
    txtFullName.setBorder(LineBorder.createBlackLineBorder)
    txtFullName.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    txtFullName.setForeground(Color.GREEN)
    txtFullName.setBackground(Color.GRAY)
    txtFullName.setOpaque(true)


    val lblEmailAddress = new JLabel("Email Address")
    lblEmailAddress.setBounds(20,180,290,27)
    lblEmailAddress.setBorder(LineBorder.createBlackLineBorder)
    lblEmailAddress.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    lblEmailAddress.setForeground(Color.WHITE)
    lblEmailAddress.setBackground(Color.BLUE)
    lblEmailAddress.setOpaque(true)

    txtEmailAddress.setBounds(360,180,290,27)
    txtEmailAddress.setBorder(LineBorder.createBlackLineBorder)
    txtEmailAddress.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    txtEmailAddress.setForeground(Color.GREEN)
    txtEmailAddress.setBackground(Color.GRAY)
    txtEmailAddress.setOpaque(true)

    btnFindCustomerDetails.setBounds(360,220,290,27)
    btnFindCustomerDetails.setBorder(LineBorder.createBlackLineBorder)
    btnFindCustomerDetails.setFont(new Font("Bookman Old Style", Font.BOLD, 18))

    btnUpdateCustomer.setBounds(360,260,290,27)
    btnUpdateCustomer.setBorder(LineBorder.createBlackLineBorder)
    btnUpdateCustomer.setFont(new Font("Bookman Old Style", Font.BOLD, 18))

    btnMainMenu.setBounds(360,300,290,27)
    btnMainMenu.setBorder(LineBorder.createBlackLineBorder)
    btnMainMenu.setFont(new Font("Bookman Old Style", Font.BOLD, 18))

    jPanel.add(lblMsgLabel)
    jPanel.add(lblFindCustomer)
    jPanel.add(cmbCustomerName)
    jPanel.add(lblFullName)
    jPanel.add(txtFullName)
    jPanel.add(lblEmailAddress)
    jPanel.add(txtEmailAddress)
    jPanel.add(btnFindCustomerDetails)
    jPanel.add(btnUpdateCustomer)
    jPanel.add(btnMainMenu)

    getContentPane.add(jPanel)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setVisible(true)

    getCustomerName()
    createNewCustomer()

  }

  def getCustomerName(): Unit ={

    var getCustomerNames = new PersonCRUDOperation()

//    var results = getCustomerNames.findCustomerNames()

//    cmbCustomerName.addItem(results)

  }
  def createNewCustomer(): Unit ={

    btnFindCustomerDetails.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {

        var test1 = new PersonCRUDOperation()


      }
    })
  }

}

object UpdateCustomerArea{
  def main(args: Array[String]): Unit = {
    val updateCustomer = new UpdateCustomer()
    updateCustomer.updateCustomerGUI()
  }
}