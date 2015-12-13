package datanormaliztiontool;

import static org.junit.Assert.assertEquals;

import datanormalizationtool.DateHandler;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.junit.Test;

/**
 * DateHandler class tests.
 */
public class DateHandlerTests {
  private static final Date EXPECTED_DATE = new GregorianCalendar(2015, 6, 4).getTime();
  
  @Test
  public void standardizeDateTestOne() {
    assertEquals(EXPECTED_DATE, DateHandler.standardizeDate("07/04/2015"));
  }
  
  @Test
  public void standardizeDateTestTwo() {
    assertEquals(EXPECTED_DATE, DateHandler.standardizeDate("07-04-2015"));
  }
  
  @Test
  public void standardizeDateTestThree() {
    assertEquals(EXPECTED_DATE, DateHandler.standardizeDate("07/04/15"));
  }
  
  @Test
  public void standardizeDateTestFour() {
    assertEquals(EXPECTED_DATE, DateHandler.standardizeDate("07-04-15"));
  }
  
  @Test
  public void standardizeDateTestFive() {
    assertEquals(EXPECTED_DATE, DateHandler.standardizeDate("July 4, 2015"));
  }
  
  @Test
  public void standardizeDateTestSix() {
    assertEquals(EXPECTED_DATE, DateHandler.standardizeDate("July 4TH, 2015"));
  }
  
  @Test
  public void standardizeDateTestSeven() {
    assertEquals(EXPECTED_DATE, DateHandler.standardizeDate("Jul 4th, 2015"));
  }
  
  @Test
  public void standardizeDateTestEight() {
    assertEquals(EXPECTED_DATE, DateHandler.standardizeDate("Jul 4, 2015"));
  }
  
  @Test
  public void formatDateTest() {
    assertEquals("07/04/2015", DateHandler.formatDate(EXPECTED_DATE));
  }
}