package datanormalizationtool.ui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.UIManager;

/**
 *
 * @author chris
 */
public class FileMenu extends JMenu {
  private JMenuItem exit;
  private JMenuItem newFile;
  private JMenuItem open;
  private JMenuItem save;
  
  public FileMenu() {
    super("File");
    setUpFileMenu();
  }
  
  private void setUpFileMenu(){
    newFile = new JMenuItem("New", UIManager.getIcon("FileView.fileIcon"));
    add(newFile);
    
    open = new JMenuItem("Open", UIManager.getIcon("FileView.directoryIcon"));
    add(open);
    
    save = new JMenuItem("Save", UIManager.getIcon("FileView.floppyDriveIcon"));
    add(save);
    
    add(new JSeparator());
    
    exit = new JMenuItem("Exit");
    add(exit);
  }
}
