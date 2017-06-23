package JavaSwinfFrontEnd

/**
  * Created by Global InfoTech Dev on 22/06/2017.
  */
import javax.swing._
import java.awt._
import java.awt.event._
import javax.swing.border._

class FloorStaff extends JFrame{

  val btnTransactions = new JButton("Transactions")
  val btnCRUDOperations = new JButton("Customer Operations")
  val btnReportAndReceipts = new JButton("View Items")
  val btnExit = new JButton("Exit Program")


  def createFloorStaffGUI(): Unit ={

    var jPanel = new JPanel()

    setTitle("Manager Operations")
    setSize(680,280)
    setLocation(600,280)
    jPanel.setLayout(null)


    val lblMsgLabel = new JLabel("Floor Staff Operations")
    lblMsgLabel.setBounds(80, 30, 510, 27)
    lblMsgLabel.setBorder(LineBorder.createBlackLineBorder)
    lblMsgLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 20))
    lblMsgLabel.setForeground(Color.WHITE)
    lblMsgLabel.setBackground(Color.BLUE)
    lblMsgLabel.setOpaque(true)

    btnTransactions.setBounds(230, 80, 210, 27)
    btnTransactions.setBorder(LineBorder.createBlackLineBorder)
    btnTransactions.setFont(new Font("Bookman Old Style", Font.BOLD, 20))

    btnCRUDOperations.setBounds(230, 120, 210, 27)
    btnCRUDOperations.setBorder(LineBorder.createBlackLineBorder)
    btnCRUDOperations.setFont(new Font("Bookman Old Style", Font.BOLD, 20))

    btnReportAndReceipts.setBounds(230, 160, 210, 27)
    btnReportAndReceipts.setBorder(LineBorder.createBlackLineBorder)
    btnReportAndReceipts.setFont(new Font("Bookman Old Style", Font.BOLD, 20))

    btnExit.setBounds(230, 200, 210, 27)
    btnExit.setBorder(LineBorder.createBlackLineBorder)
    btnExit.setFont(new Font("Bookman Old Style", Font.BOLD, 20))


    jPanel.add(lblMsgLabel)
    jPanel.add(btnTransactions)
    jPanel.add(btnCRUDOperations)
    jPanel.add(btnReportAndReceipts)
    jPanel.add(btnExit)

    getContentPane.add(jPanel)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setVisible(true)

    exitSystem()

  }

  def exitSystem(): Unit ={

    btnExit.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        System.exit(0)
      }
    })
  }

}

object FloorStaffArea{
  def main(args: Array[String]): Unit = {
    val createFloorStaff = new FloorStaff()
    createFloorStaff.createFloorStaffGUI()
  }
}
