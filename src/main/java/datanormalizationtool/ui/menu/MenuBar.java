package datanormalizationtool.ui.menu;

import javax.swing.JMenuBar;

/**
 *
 * @author chris
 */
public class MenuBar extends JMenuBar {
  public MenuBar() {
    setUpMenuBar();
  }
  
  private void setUpMenuBar() {
    add(new FileMenu());
  }
}
