package datanormalizationtool;

import datanormalizationtool.datahandlers.TableData;
import datanormalizationtool.datahandlers.GenericTableData;
import static org.junit.Assert.assertEquals;

import java.io.File;
import org.junit.Test;

/**
 *
 * Normalizer class tests.
 */
public class NormalizerTests extends TestUtils {
  
  @Test
  public void NormalizerTestOne() {
    String data     = TEST_RESOURCES_DIR + "normalizer_test_one.xlsx";
    String expected = TEST_RESOURCES_DIR + "normalizer_test_one_expected.txt";
    
    TableData table = new GenericTableData();
    table.loadData(new File(data), 0);
    
    assertEquals(fileToString(expected), table.toString());
  }
}
