package datanormalizationtool;

import java.util.Arrays;

/**
 * Class containing common header row names.
 */
public class HeaderData {
  public static final HeaderList SCHOOL_YEAR_HEADERS = new HeaderList(Arrays.asList(
    "SCHOOL_YEAR"
  ));
  
  public static final HeaderList ORD_CODE_HEADERS = new HeaderList(Arrays.asList(
    "ORG_CODE"
  ));
  
  public static final HeaderList REC_NUM_HEADERS = new HeaderList(Arrays.asList(
    "REC_NBR"
  ));
  
  public static final HeaderList FIRST_NAME_HEADERS = new HeaderList(Arrays.asList(
    "First Name", "Fname", "FIRSTNAME"
  ));

  public static final HeaderList LAST_NAME_HEADERS = new HeaderList(Arrays.asList(
    "Last Name", "Lname", "LASTNAME"
  ));

  public static final HeaderList MIDDLE_NAME_HEADERS = new HeaderList(Arrays.asList(
    "Middle Name", "Mname", "MIDDLENAME"
  ));

  public static final HeaderList BIRTH_DATE_HEADERS = new HeaderList(Arrays.asList(
    "Birth Date", "BDate", "DATEOFBIRTH"
  ));

  public static final HeaderList GRADE_HEADERS = new HeaderList(Arrays.asList(
    "Grade", "Grd"
  ));

  public static final HeaderList TOWN_CODE_HEADERS = new HeaderList(Arrays.asList(
    "Town Code", "TCode", "TOWNCODE"
  ));
  
  public static final HeaderList DOB_YEAR_HEADERS = new HeaderList(Arrays.asList(
    "DOB_YEAR"
  ));
}
