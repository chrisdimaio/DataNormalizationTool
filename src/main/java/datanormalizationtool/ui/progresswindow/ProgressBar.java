package datanormalizationtool.ui.progresswindow;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * A progress bar.
 */
public class ProgressBar extends JPanel {
  private static final int MIN_PROGRESS = 0;
  
  private final int maxProgress;
  
  private int progressValue = 0;
  
  private JProgressBar progressBar;
  
  public ProgressBar(int numberOfTasks) {
    maxProgress = numberOfTasks;
    setUpProgressBar();
  }
  
  public void updateBar() {
    progressBar.setValue(++progressValue);
  }
  
  private void setUpProgressBar() {
    progressBar = new JProgressBar();
    progressBar.setMinimum(MIN_PROGRESS);
    progressBar.setMaximum(maxProgress);
    add(progressBar);
  }
}
