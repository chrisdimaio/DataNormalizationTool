package datanormalizationtool;

import java.io.File;

class MainClass {
  private static final String SAMPLE_SCHOOL_DATA
      = "./build/resources/main/SampleWaitlist_SCHOOL.xlsx";

  public static void main(String[] args) {
    TableData table = new GenericTableData();
    table.loadData(new File(SAMPLE_SCHOOL_DATA));
    System.out.println(table);
  }
}
