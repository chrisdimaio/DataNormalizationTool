package datanormalizationtool.datahandlers;

import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 *
 * @author cdimaio
 */
public class DeseDataSheetPatterns {
  public static final LinkedList<Pattern> INITIAL;
  public static final LinkedList<Pattern> ADDITIONS;
  
  static {
    INITIAL = new LinkedList<Pattern>();
    INITIAL.add(Pattern.compile("fy\\d{2}\\s*initial"));
    
    ADDITIONS = new LinkedList<Pattern>();
    ADDITIONS.add(Pattern.compile("fy\\d{2}\\s*additions"));
  } 
}
