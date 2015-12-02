package datanormalizationtool;

import java.util.Arrays;

/**
 * Created by cdimaio on 11/30/2015.
 */
public class HeaderData {
  public static final HeaderList FIRST_NAME_HEADERS = new HeaderList(Arrays.asList(
          "First Name", "Fname"
  ));

  public static final HeaderList LAST_NAME_HEADERS = new HeaderList(Arrays.asList(
          "Last Name", "Lname"
  ));

  public static final HeaderList MIDDLE_NAME_HEADERS = new HeaderList(Arrays.asList(
          "Middle Name", "Mname"
  ));

  public static final HeaderList BIRTH_DATE_HEADERS = new HeaderList(Arrays.asList(
          "Birth Date", "BDate"
  ));

  public static final HeaderList GRADE_HEADERS = new HeaderList(Arrays.asList(
          "Grade", "Grd"
  ));

  public static final HeaderList TOWN_CODE_HEADERS = new HeaderList(Arrays.asList(
          "Town Code", "TCode"
  ));
}
