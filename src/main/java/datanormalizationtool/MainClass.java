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
    MainWindow window = new MainWindow();
    window.showUI();
    
//    TableData table = new GenericTableData();
//    table.loadData(new File(RESOURCE_DIR + SAMPLE_DUPLICATE_DATA), 0);
//    Normalizer normalizer = new Normalizer();
//    normalizer.normalize(table);
    //    System.out.println("Starting...");
    //    long start = System.currentTimeMillis();
    //    normalizer.normalize(table);
    //    long end = System.currentTimeMillis();
    //    System.out.println("Done!");
    //    long delta = (end - start) / 1000;
    //    System.out.println("It took " + delta + " seconds to complete.");
  }
}
