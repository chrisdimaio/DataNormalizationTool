package datanormalizationtool;


import datanormalizationtool.ui.MainWindow;
import java.io.File;

class MainClass {
  private static final String RESOURCE_DIR = "./build/resources/main/";
  private static final String SAMPLE_DESE_DATA = "FY16_waitlist_October_TEST.xlsx";
  private static final String SAMPLE_SCHOOL_DATA = "SampleWaitlist_SCHOOL.xlsx";
  private static final String SAMPLE_DUPLICATE_DATA = "Duplicates.xlsx";
  private static final String SAMPLE_BIG_DATA = "Big.xlsx";

  public static void main(String[] args) {
    String startDir = System.getProperty("user.home") 
            + "/Dropbox/Programming Projects/datanormalizationtool"
            + "/build/resources/main";
    
    MainWindow window = new MainWindow();
    String filePath = window.showFileChooser(startDir);
    File file = null;
    if(filePath != null) {
      file = new File(filePath);
    }
    if (file != null && file.exists()) {
      TableData table = new GenericTableData();
      table.loadData(file, 0);
      Normalizer normalizer = new Normalizer();
      normalizer.normalizeSchoolData(table);
      window.setTable(table);
      window.showUI();
    }
  }
}
