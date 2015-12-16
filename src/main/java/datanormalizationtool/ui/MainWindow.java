package datanormalizationtool.ui;

import datanormalizationtool.TableData;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

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
    mainWindow.setMinimumSize(new Dimension(800, 400));
    mainWindow.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
    DNTTable table = new DNTTable(new DNTTableModel(data), data);
    mainWindow.getContentPane().add(new JScrollPane(table));
    mainWindow.setPreferredSize(table.getPreferredSize());
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
}
