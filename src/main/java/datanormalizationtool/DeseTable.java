package datanormalizationtool;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Created by cdimaio on 12/2/2015.
 */
public class DeseTable {
  protected static final int COL_REMOVED     = 0;
  protected static final int COL_SCHOOL_YEAR = 1;
  protected static final int COL_ORD_CODE    = 2;
  protected static final int COL_REC_NBR     = 3;
  protected static final int COL_FIRSTNAME   = 4;
  protected static final int COL_LASTNAME    = 5;
  protected static final int COL_MIDDLENAME  = 6;
  protected static final int COL_DATEOFBIRTH = 7;
  protected static final int COL_TOWNCODE    = 8;
  protected static final int COL_GRADE       = 9;
  protected static final int COL_DOB_YEAR    = 10;

  protected final Table<Integer, Integer, String> table = HashBasedTable.create();

  /**
   * Table set up to DESE format.
   */
  public DeseTable() {
    setCell(0, COL_REMOVED, "Removed");
    setCell(0, COL_SCHOOL_YEAR, "SCHOOL_YEAR");
    setCell(0, COL_ORD_CODE, "ORG_CODE");
    setCell(0, COL_REC_NBR, "REC_NBR");
    setCell(0, COL_FIRSTNAME, "FIRSTNAME");
    setCell(0, COL_LASTNAME, "LASTNAME");
    setCell(0, COL_MIDDLENAME, "MIDDLENAME");
    setCell(0, COL_DATEOFBIRTH, "DATEOFBIRTH");
    setCell(0, COL_TOWNCODE, "TOWNCODE");
    setCell(0, COL_GRADE, "GRADE");
    setCell(0, COL_DOB_YEAR, "DOB_YEAR");
  }

  /**
   * Get cell value at a specified row and column.
   * @param row row of the cell you want the value of.
   * @param col column of the cell you want the value of.
   * @return value at row and column.
   */
  public String getCell(int row, int col) {
    return table.column(col).get(row);
  }

  /**
   * Set cell value at a specified row and column.
   * @param row row of the cell you want to set.
   * @param col column of the cell you want to set.
   * @param value the value to be set.
   */
  public void setCell(int row, int col, String value) {
    table.column(col).put(row, value);
  }

  /**
   * Calls the underlying tables toString method.
   * @return String representation of underlying table structure.
   */
  public String toString() {
    return table.toString();
  }
}
