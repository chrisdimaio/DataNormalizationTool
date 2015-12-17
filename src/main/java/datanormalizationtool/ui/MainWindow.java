package datanormalizationtool.ui;

import datanormalizationtool.TableData;
import datanormalizationtool.ui.menu.MenuBar;

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
public class MainWindow extends JFrame {
  private TableData data;
  
  private DNTTable      table;
  private JFileChooser  chooser;
  
  public MainWindow() {
    super("DNT");
    setLookAndFeel();
  }
  
  public String showFileChooser(String startDir) {
    chooser = new JFileChooser();
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
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(800, 400));
    setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
    table = new DNTTable(new DNTTableModel(data), data);
    
    setJMenuBar(new MenuBar());
    
    getContentPane().add(new JScrollPane(table));
    setPreferredSize(table.getPreferredSize());
    pack();
    setResizable(true);
    setVisible(true);
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
