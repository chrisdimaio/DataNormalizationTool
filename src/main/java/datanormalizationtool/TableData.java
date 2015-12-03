package datanormalizationtool;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.Iterator;

/**
 * Created by cdimaio on 11/30/2015.
 */
public abstract class TableData {
  protected final DeseTable table = new DeseTable();

  protected Sheet dataSheet;

  public abstract void loadData(File file, int sheetIndex);

  protected abstract boolean foundHeaderRow(Sheet sheet);

  /**
   * Calls the underlying tables toString method.
   * @return String representation of underlying table structure.
   */
  public String toString() {
    return table.toString();
  }

  /**
   * Finds the sheet with data table on it.
   * @param workbook wookbook containing sheets.
   * @return true if a sheet with data table is found
   */
  protected boolean foundDataSheet(Workbook workbook) {
    Iterator<Sheet> sheetIterator = workbook.sheetIterator();
    while (sheetIterator.hasNext()) {
      Sheet sheet = sheetIterator.next();
      if (foundHeaderRow(sheet)) {
        dataSheet = sheet;
        return true;
      }
    }
    return false;
  }

  /**
   * Get cell value at a specified row and column.
   * @param row row of the cell you want the value of.
   * @param col column of the cell you want the value of.
   * @return value at row and column.
   */
  protected String getCell(int row, int col) {
    return table.getCell(row, col);
  }

  /**
   * Set cell value at a specified row and column.
   * @param row row of the cell you want to set.
   * @param col column of the cell you want to set.
   * @param value the value to be set.
   */
  protected void setCell(int row, int col, String value) {
    table.setCell(row, col, value);
  }

  protected String cellToString(Cell cell) {
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
