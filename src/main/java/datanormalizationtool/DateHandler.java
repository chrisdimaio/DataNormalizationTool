package datanormalizationtool;

import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A class for handling dates of various formats.
 */
public class DateHandler {
  private static final String STANDARD_FORMAT = "yyyy-MM-dd";
  
  private static final String[] DATE_PATTERNS = {
    // Must be ordered by year format shortest to longest.
    // *Might be able to remove all '/ - ,' etc characters.
    "MM/dd/yy",
    "MM-dd-yy",
    "MMMM dd, yy",
    "MM/dd/yyyy",
    "MM-dd-yyyy",
    "MMMM dd, yyyy",
  };
  
  /**
   * Takes in dates of various formats and returns them in a standard format.
   * @param inputDate date of various format
   * @return date in standard format.
   */
  public static Date standardizeDates(String inputDate) {
    inputDate = inputDate.toLowerCase();
    inputDate = inputDate.replaceAll("st|nd|rd|th", "");
    
    try {
      Date date = DateUtils.parseDateStrictly(inputDate, DATE_PATTERNS);
      DateFormat formatter = new SimpleDateFormat(STANDARD_FORMAT, Locale.US);
      return formatter.parse(formatter.format(date));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
