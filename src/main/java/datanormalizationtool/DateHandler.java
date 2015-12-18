package datanormalizationtool;

import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * A class for handling dates of various formats.
 */
public class DateHandler {
  private static final String STANDARD_FORMAT = "MM/dd/yyyy";
  
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
   * Takes in dates of various formats and returns a Date instance.
   * @param inputDate date of various format
   * @return date Date instance.
   */
  public static Date standardizeDate(String inputDate) {
    inputDate = inputDate.toLowerCase();
    inputDate = inputDate.replaceAll("st|nd|rd|th", "");
    
    try {
      Date date = DateUtils.parseDateStrictly(inputDate, DATE_PATTERNS);
      return date;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  
  /**
   * Returns string representation of date formatted according to STANDARD_FORMAT.
   * @param date Date instance to format.
   * @return string representation of date.
   */
  public static String formatDate(Date date) {
    DateFormat formatter = new SimpleDateFormat(STANDARD_FORMAT, Locale.US);
    return formatter.format(date);
  }
  
  /**
   * Calculates age based on date string.
   * @param dobstr date to determine age from.
   * @return age base on date of birth string.
   */
  public static int calculateAgeInMonths(String dobstr) {
    try {
      Calendar dob = Calendar.getInstance(Locale.US);
      Calendar today = Calendar.getInstance(Locale.US);
      
      DateFormat formatter = new SimpleDateFormat(STANDARD_FORMAT, Locale.US);
      dob.setTime(formatter.parse(dobstr));
      
      int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
      if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
        age--;  
      } else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
          && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
        age--;  
      }
      return age * 12;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return -1;
  }
}
