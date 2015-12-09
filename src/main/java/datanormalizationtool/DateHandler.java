package datanormalizationtool;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.time.DateUtils;

/**
 * A class for handling dates of various formats.
 */
public class DateHandler {
  
  private static final String DATE_PATTERNS[] = {
    "MM/dd/yyyy",
    "MM/dd/yy",
    "MM-dd-yyyy",
    "MM-dd-yy"
  };  
  public static String dates(String inputDate) {
      try {
        Date date = DateUtils.parseDateStrictly(inputDate, DATE_PATTERNS);
        
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);

        
      } catch (Exception e) {
          e.printStackTrace();
      }
      return inputDate;
  }
}
//        DateFormat input = new SimpleDateFormat("mm-dd-yyyy");
//        DateFormat output = new SimpleDateFormat("mm/dd/yyyy");
//        
//        String inputText = "05/05/1986";
//        Date date = input.parse(inputText);
//        String outputText = output.format(date);
//        
//        System.out.println(outputText);