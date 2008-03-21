import javax.swing.JTree;
import javax.swing.plaf.TreeUI;

/**
 *
 * Ein JTree, der seine Zeilen wie eine Liste _ohne_ Einrückung entsprechend der
 * Tife im Baum darstellt.
 */

public class JTreeList extends JTree
{

  public JTreeList()
  {
  }

  /**
   * Überschreiben, weil wir immer ein eigenes UI haben.
   * Sets the L&F object that renders this component.
   *
   * @param ui  the TreeUI L&F object
   * @see UIDefaults#getUI
   */
  public void setUI(TreeUI ui) {
    super.setUI( new TreeListUI());
  }

}
