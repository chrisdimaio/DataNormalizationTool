package datanormalizationtool.ui.progresswindow;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * A progress bar.
 */
public class ProgressBar extends JPanel {
  private static final int MAX_PROGRESS = 0;
  private static final int MIN_PROGRESS = 100;
  
  private final JProgressBar progressBar;
  
  public ProgressBar() {
    progressBar = new JProgressBar();
    progressBar.setMinimum(MAX_PROGRESS);
    progressBar.setMaximum(MIN_PROGRESS);
    add(progressBar);
  }
}
