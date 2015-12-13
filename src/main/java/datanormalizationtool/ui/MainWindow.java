package datanormalizationtool.ui;

import datanormalizationtool.TableData;
import datanormalizationtool.CellData;

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
  private TableData DATA;
  
  public MainWindow(TableData table) {
    DATA = table;
  }
  
  public void showUI() {
    JFrame mainWindow = new JFrame("DNT");
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setPreferredSize(new Dimension(800, 700));
    
    JXTable table = new JXTable(new SampleTableModel());
		setLookAndFeel();
    mainWindow.getContentPane().add(new JScrollPane(table));
    
    mainWindow.pack();
    mainWindow.setResizable(true);
    mainWindow.setVisible(true);
  }
  
  private static void setLookAndFeel() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  private class SampleTableModel extends AbstractTableModel {
 
    @Override
		public int getColumnCount() {
			return DATA.getColumnCount();
		}
 
		@Override
    public String getColumnName(int column) {
			return DATA.getCell(0, column).getValue();
		}
 
    @Override
		public int getRowCount() {
			return DATA.getRowCount();
		}
    
    @Override
		public Object getValueAt(int rowIndex, int columnIndex) {
      Object result = null;
      
      CellData cell = DATA.getCell(rowIndex, columnIndex);
      if (cell != null) {
        result = cell.getValue();
      }
      
      return result;
    }
	}
}
