package datanormalizationtool.ui;

import java.awt.Dimension;
import javax.swing.table.AbstractTableModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import org.jdesktop.swingx.JXTable;

/**
 * Main window of application
 */
public class MainWindow {
  private static final String[] DATA = { "This is the 1st String", "String 2", "Another String",
    "The Final String" };
 
	private static final String[] COLUMNS = { "Name", "Length", "Upper-case" };
  
  public void showUI() {
    JFrame mainWindow = new JFrame("DNT");
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setPreferredSize(new Dimension(700, 500));
    
    JXTable table = new JXTable(new SampleTableModel());
		setLookAndFeel();
    mainWindow.getContentPane().add(new JScrollPane(table));
    
    mainWindow.pack();
    mainWindow.setResizable(false);
    mainWindow.setVisible(true);
  }
  
  private static void setLookAndFeel() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  private static class SampleTableModel extends AbstractTableModel {
 
    @Override
		public int getColumnCount() {
			return COLUMNS.length;
		}
 
		@Override
    public String getColumnName(int column) {
			return COLUMNS[column];
		}
 
    @Override
		public int getRowCount() {
			return DATA.length;
		}
    
    @Override
		public Object getValueAt(int rowIndex, int columnIndex) {
      String theData = DATA[rowIndex];
      Object result;
      switch (columnIndex) {
      case 1:
        result = theData.length(); // auto-boxing.
        break;
      case 2:
        result = theData.toUpperCase();
        break;
      default:
        result = theData;
      }
      return result;
    }
	}
}
