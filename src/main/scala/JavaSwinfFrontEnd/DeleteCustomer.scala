package JavaSwinfFrontEnd

/**
  * Created by Global InfoTech Dev on 22/06/2017.
  */
import javax.swing._
import java.awt._
import java.awt.event._
import javax.swing.border._

import ObjectCRUD.PersonCRUDOperation

class DeleteCustomer extends JFrame{

  val btnDeleteCustomer = new JButton("Delete Customer")
  val txtFullName = new JTextField()
  val txtEmailAddress = new JTextField()

  def deleteCustomerGUI(): Unit ={

    var jPanel = new JPanel()

    setTitle("Delete Customer")
    setSize(680,280)
    setLocation(600,280)
    jPanel.setLayout(null)

    val lblMsgLabel = new JLabel("Delete Customer")
    lblMsgLabel.setBounds(148, 30, 360, 27)
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

    txtFullName.setBounds(320, 100, 290, 27)
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


    txtEmailAddress.setBounds(320,140,290,27)
    txtEmailAddress.setBorder(LineBorder.createBlackLineBorder)
    txtEmailAddress.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    txtEmailAddress.setForeground(Color.GREEN)
    txtEmailAddress.setBackground(Color.GRAY)
    txtEmailAddress.setOpaque(true)

    btnDeleteCustomer.setBounds(410, 190, 100, 24)
    btnDeleteCustomer.setBorder(LineBorder.createBlackLineBorder)
    btnDeleteCustomer.setFont(new Font("Bookman Old Style", Font.BOLD, 18))

    jPanel.add(lblMsgLabel)
    jPanel.add(lblFullName)
    jPanel.add(txtFullName)
    jPanel.add(lblEmailAddress)
    jPanel.add(txtEmailAddress)
    jPanel.add(btnDeleteCustomer)

    getContentPane.add(jPanel)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setVisible(true)

    deleteCustomer()

  }

  def deleteCustomer(): Unit ={

    btnDeleteCustomer.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {

        var test1 = new PersonCRUDOperation()

        if(test1.deleteCustomer(txtFullName.getText(), txtEmailAddress.getText())=="Success"){

          JOptionPane.showMessageDialog(null, "Customer Deleted")
        }else{
          JOptionPane.showMessageDialog(null, "Wrong Details")
          txtFullName.setText("")
          txtEmailAddress.setText("")
          txtFullName.requestFocus
        }

      }
    })
  }

}

object DeleteCustomerArea{
  def main(args: Array[String]): Unit = {
    val deleteCustomer = new DeleteCustomer()
    deleteCustomer.deleteCustomerGUI()
  }
}
