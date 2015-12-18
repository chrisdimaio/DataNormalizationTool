package datanormalizationtool;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by cdimaio on 11/30/2015.
 */
public abstract class TableData {
  protected DeseTable table = new DeseTable();

  protected Sheet dataSheet;

  public abstract void loadData(File file, int sheetIndex);

  protected abstract boolean foundHeaderRow(Sheet sheet);

  /**
   * Calls the underlying tables toString method.
   * @return String representation of underlying table structure.
   */
  @Override
  public String toString() {
    return table.toString();
  }
  
  /**
   * Get cell value at a specified row and column.
   * @param row row of the cell you want the value of.
   * @param col column of the cell you want the value of.
   * @return value at row and column.
   */
  public CellData getCell(int row, int col) {
    return table.getCell(row, col);
  }
  
  /**
   * Returns the number of columns in the underlying DeseTable.
   * @return number of columns in the table.
   */
  public int getColumnCount() {
    return table.COLUMN_COUNT;
  }
  
  /**
   * Returns Map representation of row at rowIndex.
   * @param rowIndex index of the row to be returned.
   * @return Map representation of row.
   */
  public Map<Integer, CellData> getRow(int rowIndex) {
    return table.getRow(rowIndex);
  }
  
  /**
   * Returns the number of rows in the underlying DeseTable.
   * @return number of rows in the table.
   */
  public int getRowCount() {
    return table.getRowCount();
  }
  
  /**
   * Initializes row with empty CellData objects.
   * @param rowIndex index of row to be initialized.
   */
  public void initializeRow(int rowIndex) {
    table.initializeRow(rowIndex);
  }
  
  public void removeEmptyRows() {
    DeseTable newTable = new DeseTable();
    int newRowCount = 1;
    for (int i = 1; i < table.getRowCount(); i++) {
      if (!table.getRow(i).isEmpty()) {
        for (int c = 0; c < getColumnCount(); c++) {
          CellData cell = table.getCell(i, c);
          newTable.setCell(newRowCount, c, cell);
        }
        newRowCount++;
      }
    }
    table = newTable;
  }
  
  /**
   * Removes the row at rowIndex.
   * @param rowIndex index of row to be removed.
   */
  public void removeRow(int rowIndex) {
    table.removeRow(rowIndex);
  }
  
  public boolean rowHasErrors(int rowIndex) {
    return table.rowHasErrors(rowIndex);
  }
  
  public boolean rowHasWarnings(int rowIndex) {
    return table.rowHasWarnings(rowIndex);
  }
  
  protected int findHeader(HeaderList headerList, Row row) {
    Iterator<Cell> cellIterator = row.cellIterator();
    while (cellIterator.hasNext()) {
      Cell cell = cellIterator.next();
      String cellValue = cellToString(cell);
      if (headerList.contains(cellValue)) {
        return cell.getColumnIndex();
      }
    }
    return -1;
  }
  
  /**
   * Matches sheet in workbook to pattern.
   * @param patterns patterns to match worksheet.
   * @param workbook workbook containing sheets to search.
   * @return sheet matching pattern or null if no pattern was matched.
   */
  protected Sheet findSheet(LinkedList<Pattern> patterns, Workbook workbook) {
    for (Sheet sheet: workbook) {
      String sheetName = sheet.getSheetName();
      for (Pattern p: patterns) {
        if (p.matcher(sheetName.toLowerCase()).matches()) {
          return sheet;
        }
      }
    }
    return null;
  }
  
  protected Workbook readWorkbook(File file) {
    try {
      FileInputStream inputStream = new FileInputStream(file);
      return new XSSFWorkbook(inputStream);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  
  /**
   * Set cell value at a specified row and column.
   * @param row row of the cell you want to set.
   * @param col column of the cell you want to set.
   * @param value the value to be set.
   */
  protected void setCell(int row, int col, CellData value) {
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
