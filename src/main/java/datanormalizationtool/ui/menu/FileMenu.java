package datanormalizationtool.ui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 *
 * @author chris
 */
public class FileMenu extends JMenu {
  private JMenuItem open;
  private JMenuItem save;
  private JMenuItem exit;
  
  public FileMenu() {
    super("File");
    setUpFileMenu();
  }
  
  private void setUpFileMenu(){
    open = new JMenuItem("Open");
    add(open);
    
    save = new JMenuItem("Save");
    add(save);
    
    add(new JSeparator());
    
    exit = new JMenuItem("Exit");
    add(exit);
  }
}
