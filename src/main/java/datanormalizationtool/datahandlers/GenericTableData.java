package datanormalizationtool.datahandlers;

import datanormalizationtool.CellData;
import datanormalizationtool.DeseTable;
import datanormalizationtool.HeaderData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.Iterator;

/**
 * Created by cdimaio on 12/1/2015.
 */
public class GenericTableData extends TableData {

  private int headerRowIndex;
  private int rawBirthDateIndex;
  private int rawFirstNameIndex;
  private int rawGradeIndex;
  private int rawLastNameIndex;
  private int rawMiddleNameIndex;
  private int rawTownCodeIndex;

  /**
   * Loads data from file system data into this of instance of GenericTableData.
   * @param file The file to be loaded.
   * @param sheetIndex the index of the sheet to load data from.
   */
  @Override
  public void loadData(File file, int sheetIndex) {
    Workbook workbook = readWorkbook(file);

    if (foundDataSheet(workbook)) {
      Row row;
      for (int r = headerRowIndex + 1; r < dataSheet.getLastRowNum() + 1; r++) {
        row = dataSheet.getRow(r);
        initializeRow(r);
        setCell(r, DeseTable.COL_FIRSTNAME, 
                new CellData(cellToString(row.getCell(rawFirstNameIndex))));
        setCell(r, DeseTable.COL_LASTNAME, 
                new CellData(cellToString(row.getCell(rawLastNameIndex))));
        setCell(r, DeseTable.COL_MIDDLENAME, 
                new CellData(cellToString(row.getCell(rawMiddleNameIndex))));
        setCell(r, DeseTable.COL_DATEOFBIRTH, 
                new CellData(cellToString(row.getCell(rawBirthDateIndex))));
        setCell(r, DeseTable.COL_TOWNCODE, 
                new CellData(cellToString(row.getCell(rawTownCodeIndex))));
        setCell(r, DeseTable.COL_GRADE, 
                new CellData(cellToString(row.getCell(rawGradeIndex))));
      }
    } else {
      System.out.println("No header row found.");
    }
  }
  
  @Override
  protected boolean foundHeaderRow(Sheet sheet) {
    boolean headerRowFound = false;

    Iterator<Row> iterator = sheet.iterator();
    while (!headerRowFound && iterator.hasNext()) {
      Row row = iterator.next();
      rawBirthDateIndex = findHeader(HeaderData.BIRTH_DATE_HEADERS, row);
      rawFirstNameIndex = findHeader(HeaderData.FIRST_NAME_HEADERS, row);
      rawGradeIndex = findHeader(HeaderData.GRADE_HEADERS, row);
      rawLastNameIndex = findHeader(HeaderData.LAST_NAME_HEADERS, row);
      rawMiddleNameIndex = findHeader(HeaderData.MIDDLE_NAME_HEADERS, row);
      rawTownCodeIndex = findHeader(HeaderData.TOWN_CODE_HEADERS, row);

      headerRowFound = (rawBirthDateIndex != -1)
              && (rawFirstNameIndex != -1)
              && (rawGradeIndex != -1)
              && (rawLastNameIndex != -1)
              && (rawMiddleNameIndex != -1)
              && (rawTownCodeIndex != -1);

      if (headerRowFound) {
        headerRowIndex = row.getRowNum();
      }
    }
    return headerRowFound;
  }
  
  /**
   * Finds the sheet with data table on it.
   * @param workbook workbook containing sheets.
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
}