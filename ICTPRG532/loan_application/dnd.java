package test3;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;



public class dnd extends JFrame implements DropTargetListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
DropTarget dt;
  JTextArea mytext = new JTextArea();
  public dnd() {
    super("My GUI DnD Demo");
    setSize(650, 480);
    getContentPane().add(new JLabel("Please drag a file and drop it here:"), BorderLayout.NORTH); // or JtextAarea
    
    
    getContentPane().add(mytext, BorderLayout.CENTER);
    dt = new DropTarget(mytext, this);
    // set the textfield as the drop target
    setVisible(true);
  }

  public void dragEnter(DropTargetDragEvent dtde) {
    // Drag Enter
  }

  public void dragExit(DropTargetEvent dte) {
   //Drag Exit
  }

  public void dragOver(DropTargetDragEvent dtde) {
    //Drag Over
  }

  public void dropActionChanged(DropTargetDragEvent dtde) {
    // When Drop Action is changed;
  }
 
  
  public void drop(DropTargetDropEvent dtde) {
    try {
      Transferable tr = dtde.getTransferable();
      DataFlavor[] flavors = tr.getTransferDataFlavors();
      // put data flavors in a array, consider the following data flavors:
      
      for (int i = 0; i < flavors.length; i++) {
    	  
        if (flavors[i].isFlavorJavaFileListType()) {
          dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
          List list = (List) tr.getTransferData(flavors[i]);
          for (int j = 0; j < list.size(); j++) {
        	  mytext.setText("You dropped a file:"+"\n\n");
        	  mytext.append(list.get(j) + "\n");
        	  
          }
          dtde.dropComplete(true);
          return;
          
        } else if (flavors[i].isFlavorTextType()) {
            dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
            mytext.setText("You dropped a text:"+"\n\n");
            String mystring = (String)tr.getTransferData(flavors[i]);
            mytext.append(mystring+"\n\n");
            dtde.dropComplete(true);
            return;
          }

         else if (flavors[i].isFlavorSerializedObjectType()) {
          dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
          Object obj = tr.getTransferData(flavors[i]);
          mytext.setText("You dropped an Object"+"\n\n");
          mytext.append("Object: " + obj);
          dtde.dropComplete(true);
          return;
          
        } else if (flavors[i].isRepresentationClassInputStream()) {
          dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
          mytext.read(new InputStreamReader((InputStream) tr.getTransferData(flavors[i])),
              "You dropped something from the clipboard"+"\n\n");
          dtde.dropComplete(true);
          return;
        }
      }
      dtde.rejectDrop();
    } catch (Exception ex) {
      ex.printStackTrace();
      
      dtde.rejectDrop();
    }
  }
  public static void main(String args[]) {
    new dnd();
  }
}
