package datanormaliztiontool;

import static org.junit.Assert.assertEquals;

import datanormalizationtool.GenericTableData;
import datanormalizationtool.TableData;
import org.junit.Test;

import java.io.File;

/**
 * Tests for GenericTableData class.
 */
public class GenericTableDataTests {
  static final String TEST_RESOURCES_DIR = "./build/resources/test/generictabledatatests/";

  @Test
  public void loadDataTestOne() {
    String data = TEST_RESOURCES_DIR + "load_data_test_one.xlsx";
    TableData table = new GenericTableData();
    table.loadData(new File(data));
    assertEquals(GenericTableDataExpected.LOAD_DATA_TEST_ONE, table.toString());
  }
}
