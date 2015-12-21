package datanormalizationtool.ui.progresswindow;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JDialog;

/**
 * A window that visualizes progress.
 */
public class ProgressWindow extends JDialog {
//  private final JFrame      frame;
  private final ProgressBar progressBar;
  
  public ProgressWindow(int numberOfTasks) {
    super(new JFrame("Progress..."));
    progressBar = new ProgressBar(numberOfTasks);
    setUpProgressWindow();
  }
  
  public void updateBar() {
    progressBar.updateBar();
  }
  
  private void setUpProgressWindow() {
    setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    setContentPane(progressBar);
    setAlwaysOnTop(true);
    this.setLocationRelativeTo(null);
    pack();
    setVisible(true);
  }
}
