package datanormaliztiontool;

import static org.junit.Assert.assertEquals;

import datanormalizationtool.DeseTable;
import org.junit.Test;

/**
 * Created by cdimaio on 12/2/2015.
 */
public class DeseTableTests {

  @Test
  public void deseTableInstantiationTest() {
    DeseTable table = new DeseTable();
    System.out.println(table);
    assertEquals("", "");
  }
}
