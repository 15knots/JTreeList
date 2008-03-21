import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.AbstractLayoutCache;
//import javax.swing.plaf.basic.BasicListUI;
import javax.swing.JTree;
import javax.swing.tree.*;
import java.awt.Rectangle;
import java.awt.Insets;
import java.util.*;
import java.text.*;
import java.beans.*;


/**
 * Ein TreeUI, dass die Zeilen wie bei einer Liste nicht einrückt.
 * Die Zeilen erstrecken sich immer über die gesamte Breite des JTree.
 */
public class TreeListUI extends BasicTreeUI
{

  private static boolean useMyNodeDims= true;  // alternatevie mit weniger aufwand?

  public TreeListUI()
  {
  }

  /** Überschrieben, um die X-Position anders zu setzen.
   * Creates an instance of NodeDimensions that is able to determine
   * the size of a given node in the tree.
   */
  protected AbstractLayoutCache.NodeDimensions
  createNodeDimensions()  {
      if( !useMyNodeDims) {
	return super.createNodeDimensions();
      } else {
	return new BasicTreeUI.NodeDimensionsHandler()
	{
	  /**
	   * Responsible for getting the size of a particular node.
	   */
	  public Rectangle getNodeDimensions(Object value, int row,
					     int depth, boolean expanded,
					     Rectangle size)
	  {
	    Rectangle bounds= super.getNodeDimensions(value, row, depth, expanded, size);
      System.out.println("bounds 1    = "+bounds);
	    if(tree != null) {
	      Insets insets = tree.getInsets();

	      // volle breite erzwingen..
	      int w= tree.getWidth();
	      if ( w>=0) { 	      bounds.width= w-bounds.x;  }
	      if(insets != null) {
		bounds.width-= (insets.left + insets.right);
	      }
      System.out.println("new bounds 1= "+bounds);
	    }
	    return bounds;

	  }


	  /**
	   * @return amount to indent the given row.
	   */
	  protected int getRowX(int row, int depth) {
	//    System.out.println("totalChildIndent="+totalChildIndent);
	      return totalChildIndent;
	  }
	};
      }
  }

  //-------------------------------------------------------------------------
  // alternative version??
  public void setLeftChildIndent(int newAmount) {
      newAmount = 0;
     super.setLeftChildIndent(newAmount);
  }

  public void setRightChildIndent(int newAmount) {
      newAmount = 0;
      super.setRightChildIndent(newAmount);
     }

  /**
    * Returns the Rectangle enclosing the label portion that the
    * last item in path will be drawn into.  Will return null if
    * any component in path is currently valid.
    */
  public Rectangle XXXgetPathBounds(JTree tree, TreePath path) {
      Rectangle bounds= super.getPathBounds(tree, path);

  System.out.println("bounds    = "+bounds);
	if(tree != null && bounds != null) {
	  Insets insets = tree.getInsets();

	  // volle breite erzwingen..
	  bounds.width= tree.getWidth()-bounds.x;
	  if(insets != null) {
	    // volle breite erzwingen..
	    bounds.width-= (insets.left + insets.right);
	  }
  System.out.println("new bounds= "+bounds);
	}
      return bounds;
  }

  /**
   * Returns true if the expand (toggle) control should be drawn for
   * the specified row.
   */
  protected boolean shouldPaintExpandControl(TreePath path, int row,
					     boolean isExpanded,
					     boolean hasBeenExpanded,
					     boolean isLeaf)
  {
    return false;
  }

}
