package datanormaliztiontool;

import static org.junit.Assert.assertEquals;

import datanormalizationtool.DeseTable;
import org.junit.Test;

/**
 * Created by cdimaio on 12/2/2015.
 */
public class DeseTableTests extends TestUtils {

  @Test
  public void deseTableInstantiationTest() {
    String expected = TEST_RESOURCES_DIR + "dese_table_instantiation_test_expected.txt";
    
    DeseTable table = new DeseTable();
    assertEquals(fileToString(expected), table.toString());
  }
}
