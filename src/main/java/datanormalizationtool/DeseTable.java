package datanormalizationtool;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Map;

/**
 * Table set up in DESE format.
 */
public class DeseTable {
  public static final int COLUMN_COUNT = 11;
  
  public static final int COL_REMOVED     = 0;
  public static final int COL_SCHOOL_YEAR = 1;
  public static final int COL_ORD_CODE    = 2;
  public static final int COL_REC_NBR     = 3;
  public static final int COL_FIRSTNAME   = 4;
  public static final int COL_LASTNAME    = 5;
  public static final int COL_MIDDLENAME  = 6;
  public static final int COL_DATEOFBIRTH = 7;
  public static final int COL_TOWNCODE    = 8;
  public static final int COL_GRADE       = 9;
  public static final int COL_DOB_YEAR    = 10;

  private final Table<Integer, Integer, CellData> table 
          = HashBasedTable.create();
  
  /**
   * Constructor for DESE table.
   */
  public DeseTable() {
    table.column(COL_REMOVED).put(0, new CellData("Removed"));
    table.column(COL_SCHOOL_YEAR).put(0, new CellData("SCHOOL_YEAR"));
    table.column(COL_ORD_CODE).put(0, new CellData("ORG_CODE"));
    table.column(COL_REC_NBR).put(0, new CellData("REC_NBR"));
    table.column(COL_FIRSTNAME).put(0, new CellData("FIRSTNAME"));
    table.column(COL_LASTNAME).put(0, new CellData("LASTNAME"));
    table.column(COL_MIDDLENAME).put(0, new CellData("MIDDLENAME"));
    table.column(COL_DATEOFBIRTH).put(0, new CellData("DATEOFBIRTH"));
    table.column(COL_TOWNCODE).put(0, new CellData("TOWNCODE"));
    table.column(COL_GRADE).put(0, new CellData("GRADE"));
    table.column(COL_DOB_YEAR).put(0, new CellData("DOB_YEAR"));
  }
  
  /**
   * @param row row of the cell you want the value of.
   * @param col column of the cell you want the value of.
   * @return value at row and column.
   */
  public CellData getCell(int row, int col) {
    return table.column(col).get(row);
  }
  
  /**
   * Returns Map representation of row at rowIndex.
   * @param rowIndex index of the row to be returned.
   * @return Map representation of row.
   */
  public Map<Integer, CellData> getRow(int rowIndex) {
    return table.row(rowIndex);
  }
  
  /**
   * Returns the number of rows in the table.
   * @return number of rows in the table.
   */
  public int getRowCount() {
    return table.rowMap().size();
  }
  
  /**
   * Initializes row with empty CellData objects.
   * @param rowIndex index of row to be initialized.
   */
  public void initializeRow(int rowIndex) {
    for (int i = 0; i < DeseTable.COLUMN_COUNT; i++) {
      table.column(i).put(rowIndex, new CellData(""));
    }
  }
  
  /**
   * Removes the row at rowIndex.
   * @param rowIndex index of row to be removed.
   */
  public void removeRow(int rowIndex) {
    table.row(rowIndex).clear();
  }
  
  /**
   * @param row row of the cell you want to set.
   * @param col column of the cell you want to set.
   * @param value the value to be set.
   */
  public void setCell(int row, int col, CellData value) {
    table.column(col).put(row, value);
  }

  /**
   * Calls the underlying tables toString method.
   * @return String representation of underlying table structure.
   */
  @Override
  public String toString() {
    String str = "";
    for (int y = 0; y < getRowCount(); y++) {
      Map<Integer, CellData> row = table.row(y);
      if (!row.isEmpty()) {
        str += "{";
        for (int x = 0; x < row.size(); x++) {
          CellData cell = row.get(x);
          str += cell + (x + 1 < row.size() ? ", " : "");
        }
        str += (y + 1 < getRowCount() ? "}\n" : "}");
      }
    }
    return str;
  }
}
