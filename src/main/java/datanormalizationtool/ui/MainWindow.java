package datanormalizationtool.ui;

import datanormalizationtool.TableData;
import datanormalizationtool.CellData;

import java.awt.Dimension;
import java.io.File;
import javax.swing.table.AbstractTableModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import org.jdesktop.swingx.JXTable;

/**
 * Main window of application
 */
public class MainWindow {
  private TableData data;
  
  public MainWindow() {
    setLookAndFeel();
  }
  
  public String showFileChooser(String startDir) {
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = 
            new FileNameExtensionFilter("Excel Spreadsheet", "xlsx");
    chooser.setFileFilter(filter);
    chooser.setCurrentDirectory(new File(startDir));
    int returnVal = chooser.showOpenDialog(null);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
      return chooser.getSelectedFile().getAbsolutePath();
    }
    return null;
  }
  
  public void showUI() {
    JFrame mainWindow = new JFrame("DNT");
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setPreferredSize(new Dimension(800, 700));
    
    JXTable table = new JXTable(new TableModel());
    mainWindow.getContentPane().add(new JScrollPane(table));
    
    mainWindow.pack();
    mainWindow.setResizable(true);
    mainWindow.setVisible(true);
  }
  
  public void setTable(TableData table) {
    data = table;
  }
  
  private static void setLookAndFeel() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  private class TableModel extends AbstractTableModel {
 
    @Override
		public int getColumnCount() {
			return data.getColumnCount();
		}
 
		@Override
    public String getColumnName(int column) {
			return data.getCell(0, column).getValue();
		}
 
    @Override
		public int getRowCount() {
			return data.getRowCount() - 1;
		}
    
    @Override
		public Object getValueAt(int rowIndex, int columnIndex) {
      Object result = null;
      
      CellData cell = data.getCell(rowIndex + 1, columnIndex);
      if (cell != null) {
        result = cell.getValue();
      }
      
      return result;
    }
	}
}
