package datanormalizationtool;

import datanormalizationtool.datahandlers.DeseInitialDataHandler;
import datanormalizationtool.datahandlers.GenericTableData;
import datanormalizationtool.datahandlers.TableData;

import datanormalizationtool.ui.MainWindow;
import datanormalizationtool.ui.progresswindow.ProgressWindow;

import java.io.File;

class MainClass {
  private static final String RESOURCE_DIR          = "./build/resources/main/";
  private static final String SAMPLE_BIG_DATA       = "Big.xlsx";
  private static final String SAMPLE_DESE_DATA      = "FY16_waitlist_October_TEST.xlsx";
  private static final String SAMPLE_DUPLICATE_DATA = "Duplicates.xlsx";
  private static final String SAMPLE_SCHOOL_DATA    = "SampleWaitlist_SCHOOL.xlsx";
  
  public static void main(String[] args) {
    String startDir = System.getProperty("user.home") 
            + "/Dropbox/Programming Projects/datanormalizationtool"
            + "/build/resources/main";
    
    MainWindow window = new MainWindow();
    String schoolDataPath   = window.showFileChooser(startDir);
    String initialDataPath  = window.showFileChooser(startDir);
    ProgressWindow progressBar = new ProgressWindow(13);
    progressBar.updateBar();
    
    TableData schoolData = new GenericTableData();
    schoolData.loadData(getValidFile(schoolDataPath), 0);
    progressBar.updateBar();
    
    TableData initialData = new DeseInitialDataHandler();
    initialData.loadData(getValidFile(initialDataPath), 0);
    progressBar.updateBar();
    
    Normalizer normalizer = new Normalizer();
    normalizer.normalizeSchoolData(schoolData, progressBar);
    progressBar.updateBar();
    
    
    window.setTable(schoolData);
    window.showUI();
    progressBar.updateBar();
  }
  
  private static File getValidFile(String path) {
    if (path != null) {
      File result = new File(path);
      if (result.exists()) {
        return result;
      }
    }
    return null;
  }
}
