package datanormalizationtool;

import java.util.HashMap;
import java.util.Map;

/**
 * A mapping of various grade name permutations to their grade code.
 */
public class GradeMappings {
  
  /**
   * Returns age according to grade.
   * @param grade to map to age.
   * @return age that maps to grade.
   */
  public static final int getAge(String grade) {
    return GRADE_AGE_MAP.get(grade.toLowerCase());
  }
  
  /**
   * Maps grade name to it's town code.
   * @param name name of grade to map to town code.
   * @return town code.
   */
  public static final String getGradeCode(String name) {
    return GRADE_CODE_MAP.get(name.toLowerCase());
  }
  
  /**
   * Check if code is a valid grade code.
   * @param code town code to validate.
   * @return true if grade code is valid.
   */
  public static final boolean isGradeCode(String code) {
    return GRADE_CODE_MAP.containsValue(code.toLowerCase());
  }
  
  /**
   * Check if name is a valid grade name.
   * @param name town name to validate.
   * @return true if grade name is valid.
   */
  public static final boolean isGradeName(String name) {
    return GRADE_CODE_MAP.containsKey(name.toLowerCase());
  }
  
  private static final Map<String, Integer> GRADE_AGE_MAP;
  
  static {
    GRADE_AGE_MAP = new HashMap<String, Integer>();
    GRADE_AGE_MAP.put("pk", 48);
    GRADE_AGE_MAP.put("k", 60);
    GRADE_AGE_MAP.put("01", 72);
    GRADE_AGE_MAP.put("02", 84);
    GRADE_AGE_MAP.put("03", 96);
    GRADE_AGE_MAP.put("04", 108);
    GRADE_AGE_MAP.put("05", 120);
    GRADE_AGE_MAP.put("06", 132);
    GRADE_AGE_MAP.put("07", 144);
    GRADE_AGE_MAP.put("08", 156);
    GRADE_AGE_MAP.put("09", 168);
    GRADE_AGE_MAP.put("10", 180);
    GRADE_AGE_MAP.put("11", 192);
    GRADE_AGE_MAP.put("12", 204);
  }
  
  private static final Map<String, String> GRADE_CODE_MAP;
  
  static {
    GRADE_CODE_MAP = new HashMap<String, String>();
    GRADE_CODE_MAP.put("prek", "pk");
    GRADE_CODE_MAP.put("pre kindergarten", "pk");
    
    GRADE_CODE_MAP.put("kindergarten", "k");
    
    GRADE_CODE_MAP.put("first", "01");
    GRADE_CODE_MAP.put("grade 1", "01");
    
    GRADE_CODE_MAP.put("second", "02");
    GRADE_CODE_MAP.put("grade 2", "02");
    
    GRADE_CODE_MAP.put("grade 3", "03");
    GRADE_CODE_MAP.put("third", "03");
    
    GRADE_CODE_MAP.put("fourth", "04");
    GRADE_CODE_MAP.put("grade 4", "04");
    
    GRADE_CODE_MAP.put("fifth", "05");
    GRADE_CODE_MAP.put("grade 5", "05");
    
    GRADE_CODE_MAP.put("grade 6", "06");
    GRADE_CODE_MAP.put("sixth", "06");
    
    GRADE_CODE_MAP.put("grade 7", "07");
    GRADE_CODE_MAP.put("seventh", "07");
    
    GRADE_CODE_MAP.put("grade 8", "08");
    GRADE_CODE_MAP.put("eighth", "08");
    
    GRADE_CODE_MAP.put("grade 9", "09");
    GRADE_CODE_MAP.put("ninth", "09");
    
    GRADE_CODE_MAP.put("grade 10", "10");
    GRADE_CODE_MAP.put("tenth 10", "10");
    
    GRADE_CODE_MAP.put("eleventh", "11");
    GRADE_CODE_MAP.put("grade 11", "11");
    
    GRADE_CODE_MAP.put("grade 12", "12");
    GRADE_CODE_MAP.put("twelth", "12");
  }
}
