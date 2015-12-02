package datanormalizationtool;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.util.Map;

/**
 * Created by cdimaio on 11/30/2015.
 */
public abstract class TableData {
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

  private final Table<Integer, Integer, String> table = HashBasedTable.create();

  public abstract void loadData(File file);

  /**
   * Calls the underlying tables toString method.
   * @return String representation of underlying table structure.
   */
  public String toString() {
    return table.toString();
  }

  /**
   * Get cell value at a specified row and column.
   * @param row
   * @param col
   * @return value at row and column.
   */
  protected String getCell(int row, int col) {
    return table.column(col).get(row);
  }

  /**
   * Set cell value at a specified row and column.
   * @param row
   * @param col
   * @param value
   */
  protected void setCell(int row, int col, String value) {
    table.column(col).put(row, value);
  }

  String cellToString(Cell cell) {
    String cellValue = "";
    switch (cell.getCellType()) {
      case Cell.CELL_TYPE_STRING:
        cellValue = cell.getStringCellValue();
        break;
      case Cell.CELL_TYPE_BOOLEAN:
        cellValue = Boolean.toString(cell.getBooleanCellValue());
        break;
      case Cell.CELL_TYPE_NUMERIC:
        cellValue = Double.toString(cell.getNumericCellValue());
        break;
      default:
        break;
    }
    return cellValue;
  }
}
