package datanormalizationtool;

import java.io.File;

class MainClass {
  private static final String RESOURCE_DIR = "./build/resources/main/";
  
  private static final String SAMPLE_DESE_DATA = RESOURCE_DIR + "FY16_waitlist_October_TEST.xlsx";
  private static final String SAMPLE_SCHOOL_DATA = RESOURCE_DIR + "SampleWaitlist_SCHOOL.xlsx";
  private static final String SAMPLE_DUPLICATE_DATA = RESOURCE_DIR + "Duplicates.xlsx";

  public static void main(String[] args) {
    TableData table = new GenericTableData();
    table.loadData(new File(SAMPLE_DUPLICATE_DATA), 0);
    Normalizer normalizer = new Normalizer();
    normalizer.normalize(table);
  }
}
