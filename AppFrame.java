import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class AppFrame extends JFrame
{
  JPanel contentPane;
  Border border1;
  JSplitPane jSplitPane1 = new JSplitPane();
  JTreeList jTreeList1 = new JTreeList();
  JScrollPane jScrollPane2 = new JScrollPane();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTree jTree1 = new JTree();
  BorderLayout borderLayout1 = new BorderLayout();
  JList jList1 = new JList(new String[]{"eeins" ,"zwei", "assad", "vire"});

  /**Construct the frame*/
  public AppFrame()
  {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  /**Component initialization*/
  private void jbInit() throws Exception
  {
    //setIconImage(Toolkit.getDefaultToolkit().createImage(AppFrame.class.getResource("[Your Icon]")));
    contentPane = (JPanel) this.getContentPane();
    border1 = BorderFactory.createLineBorder(Color.cyan,7);
    contentPane.setLayout(borderLayout1);
    this.setForeground(Color.black);
    jTreeList1.setBackground(Color.yellow);
    jTreeList1.setBorder(border1);
    jTreeList1.setPreferredSize(new Dimension(80, 100));
    jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
    jSplitPane1.setPreferredSize(new Dimension(70, 200));
    jSplitPane1.setOneTouchExpandable(true);
    jTree1.setBackground(Color.gray);
    jTree1.setBorder(border1);
    jTree1.setPreferredSize(new Dimension(80, 100));
    jList1.setBackground(Color.gray);
    jList1.setMinimumSize(new Dimension(100, 50));
    jList1.setPreferredSize(new Dimension(80, 100));
    jList1.setSelectedIndex(1);
    contentPane.add(jList1, BorderLayout.NORTH);
    contentPane.add(jSplitPane1, BorderLayout.CENTER);
    jSplitPane1.add(jScrollPane1, JSplitPane.TOP);
    jSplitPane1.add(jScrollPane2, JSplitPane.BOTTOM);
    jScrollPane1.getViewport().add(jTreeList1, null);
    jScrollPane2.getViewport().add(jTree1, null);
    this.setSize(new Dimension(300, 400));
    this.setTitle("Tree ohne eingerückte Darstellung");
    jSplitPane1.setDividerLocation(150);
  }
  /**Overridden so we can exit when window is closed*/
  protected void processWindowEvent(WindowEvent e)
  {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING)
    {
      System.exit(0);
    }
  }

  public class MyCellRenderer extends javax.swing.tree.DefaultTreeCellRenderer {
  }
  {

  }

}
