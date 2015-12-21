package datanormalizationtool;

import datanormalizationtool.datahandlers.TableData;
import datanormalizationtool.datahandlers.GenericTableData;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.File;

/**
 * Tests for GenericTableData class.
 */
public class GenericTableDataTests extends TestUtils {
  
  @Test
  public void loadDataTestOne() {
    String data     = TEST_RESOURCES_DIR + "load_data_test_one.xlsx";
    String expected = TEST_RESOURCES_DIR + "load_data_test_one_expected.txt";

    int sheetIndex = 0;

    TableData table = new GenericTableData();
    table.loadData(new File(data), sheetIndex);

    assertEquals(fileToString(expected), table.toString());
  }
}
