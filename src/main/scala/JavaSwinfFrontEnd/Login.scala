package JavaSwinfFrontEnd

/**
  * Created by Global InfoTech Dev on 21/06/2017.
  */

import javax.swing._
import java.awt._
import java.awt.event._
import javax.swing.border._

import BackEnd.PersonCRUDOperation

class Login extends JFrame{

  val btnLogin = new JButton("Login")
  val txtPassword = new JTextField()
  val txtUsername = new JTextField()

  def createLoginGUI(): Unit ={

    var jPanel = new JPanel()

    setTitle("Elliot and Friends Game Store")
    setSize(680,280)
    setLocation(600,280)
    jPanel.setLayout(null)

    val lblMsgLabel = new JLabel("Login Authentication")
    lblMsgLabel.setBounds(148, 30, 360, 27)
    lblMsgLabel.setBorder(LineBorder.createBlackLineBorder)
    lblMsgLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    lblMsgLabel.setForeground(Color.WHITE)
    lblMsgLabel.setBackground(Color.BLUE)
    lblMsgLabel.setOpaque(true)

    val lblUsername = new JLabel("Username")
    lblUsername.setBounds(20, 100, 290, 27)
    lblUsername.setBorder(LineBorder.createBlackLineBorder)
    lblUsername.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    lblUsername.setForeground(Color.WHITE)
    lblUsername.setBackground(Color.BLUE)
    lblUsername.setOpaque(true)

    txtUsername.setBounds(320, 100, 290, 27)
    txtUsername.setBorder(LineBorder.createBlackLineBorder)
    txtUsername.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    txtUsername.setForeground(Color.GREEN)
    txtUsername.setBackground(Color.GRAY)
    txtUsername.setOpaque(true)

    val lblPassword = new JLabel("Password")
    lblPassword.setBounds(20,140,290,27)
    lblPassword.setBorder(LineBorder.createBlackLineBorder)
    lblPassword.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    lblPassword.setForeground(Color.WHITE)
    lblPassword.setBackground(Color.BLUE)
    lblPassword.setOpaque(true)


    txtPassword.setBounds(320,140,290,27)
    txtPassword.setBorder(LineBorder.createBlackLineBorder)
    txtPassword.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    txtPassword.setForeground(Color.GREEN)
    txtPassword.setBackground(Color.GRAY)
    txtPassword.setOpaque(true)

    btnLogin.setBounds(410, 190, 100, 24)
    btnLogin.setBorder(LineBorder.createBlackLineBorder)
    btnLogin.setFont(new Font("Bookman Old Style", Font.BOLD, 18))

    jPanel.add(lblMsgLabel)
    jPanel.add(lblUsername)
    jPanel.add(txtUsername)
    jPanel.add(lblPassword)
    jPanel.add(txtPassword)
    jPanel.add(btnLogin)

    getContentPane.add(jPanel)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setVisible(true)

    verifyLogin()

  }

  def verifyLogin(): Unit ={

    btnLogin.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {

        var test1 = new PersonCRUDOperation()

        if(test1.verify(txtUsername.getText(), txtPassword.getText())=="Manager"){

          JOptionPane.showMessageDialog(null, "Login Successful. Welcome To The Manager Operations: " + txtUsername.getText())

          val displayManagerGUI = new Manager()
          displayManagerGUI.createManagerGUI()
          dispose()
        }else if(test1.verify(txtUsername.getText(), txtPassword.getText())=="Floor Staff"){

          JOptionPane.showMessageDialog(null, "Login Successful. Welcome To The Floor Staff Operations: " + txtUsername.getText())
          val displayManagerGUI = new FloorStaff()
          displayManagerGUI.createFloorStaffGUI()
          dispose()
        }else{
          JOptionPane.showMessageDialog(null, "Wrong Password / Username")
          txtUsername.setText("")
          txtPassword.setText("")
          txtUsername.requestFocus
        }
      }
    })
  }

}

  object LoginArea{
    def main(args: Array[String]): Unit = {
      val createLogin = new Login()
      createLogin.createLoginGUI()
    }
  }

