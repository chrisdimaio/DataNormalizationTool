package datanormalizationtool;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.util.Map;

/**
 * Created by cdimaio on 11/30/2015.
 */
abstract class TableData {
  static final int COL_REMOVED     = 0;
  static final int COL_SCHOOL_YEAR = 1;
  static final int COL_ORD_CODE    = 2;
  static final int COL_REC_NBR     = 3;
  static final int COL_FIRSTNAME   = 4;
  static final int COL_LASTNAME    = 5;
  static final int COL_MIDDLENAME  = 6;
  static final int COL_DATEOFBIRTH = 7;
  static final int COL_TOWNCODE    = 8;
  static final int COL_GRADE       = 9;
  static final int COL_DOB_YEAR    = 10;

  final Table<Integer, Integer, String> table = HashBasedTable.create();

  public abstract void loadData(File file);

  public String toString() {
    return table.toString();
  }

  protected String getCell(int row, int col) {
    return table.column(col).get(row);
  }

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
