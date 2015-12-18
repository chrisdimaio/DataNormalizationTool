package datanormalizationtool.datahandlers;

import datanormalizationtool.CellData;
import datanormalizationtool.DeseTable;
import datanormalizationtool.HeaderData;
import datanormalizationtool.TableData;

import java.io.File;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Class for loading and understanding DESE forms.
 */
public class DeseInitialDataHandler extends TableData {
  
  private int headerRowIndex;
  private int rawSchoolYear;
  private int rawOrgCode;
  private int rawRecNbr;
  private int rawBirthDateIndex;
  private int rawFirstNameIndex;
  private int rawGradeIndex;
  private int rawLastNameIndex;
  private int rawMiddleNameIndex;
  private int rawTownCodeIndex;
  private int rawDOBYear;
  
  @Override
  public void loadData(File file, int sheetIndex) {
    Workbook workbook = readWorkbook(file);
    
    if (foundDataSheet(workbook)) {
      Row row;
      for (int r = headerRowIndex + 1; r < dataSheet.getLastRowNum() + 1; r++) {
        row = dataSheet.getRow(r);
        if (!isRowEmpty(row)) {
          initializeRow(r);

          String cellValue = cellToString(row.getCell(rawSchoolYear));
          setCell(r, DeseTable.COL_SCHOOL_YEAR, new CellData(cellValue));  

          cellValue = cellToString(row.getCell(rawOrgCode));
          setCell(r, DeseTable.COL_ORD_CODE, new CellData(cellValue));

          cellValue = cellToString(row.getCell(rawRecNbr));
          setCell(r, DeseTable.COL_REC_NBR, new CellData(cellValue));

          cellValue = cellToString(row.getCell(rawFirstNameIndex));
          setCell(r, DeseTable.COL_FIRSTNAME, new CellData(cellValue));

          cellValue = cellToString(row.getCell(rawLastNameIndex));
          setCell(r, DeseTable.COL_LASTNAME, new CellData(cellValue));

          cellValue = cellToString(row.getCell(rawMiddleNameIndex));
          setCell(r, DeseTable.COL_LASTNAME, new CellData(cellValue));

          cellValue = cellToString(row.getCell(rawBirthDateIndex));
          setCell(r, DeseTable.COL_DATEOFBIRTH, new CellData(cellValue));

          cellValue = cellToString(row.getCell(rawTownCodeIndex));
          setCell(r, DeseTable.COL_TOWNCODE, new CellData(cellValue));

          cellValue = cellToString(row.getCell(rawGradeIndex));
          setCell(r, DeseTable.COL_GRADE, new CellData(cellValue));

          cellValue = cellToString(row.getCell(rawDOBYear));
          setCell(r, DeseTable.COL_DOB_YEAR, new CellData(cellValue));
        }
      }
    } else {
      System.out.println("No header row found.");
    }
  }
  
  private boolean isRowEmpty(Row r) {
    boolean result = true;
    for (Cell c: r) {
      String cellValue = cellToString(c);
      result = result && cellValue.isEmpty();
    }
    return result;
  }
  private boolean foundDataSheet(Workbook workbook) {
    Sheet sheet = findSheet(SheetPatterns.INITIAL, workbook);
    System.out.println(sheet.getSheetName());
    if (foundHeaderRow(sheet)) {
      dataSheet = sheet;
      return true;
    }
    return false;
  }
  
  @Override
  protected boolean foundHeaderRow(Sheet sheet) {
    boolean headerRowFound = false;

    Iterator<Row> iterator = sheet.iterator();
    while (!headerRowFound && iterator.hasNext()) {
      Row row = iterator.next();
      rawSchoolYear       = findHeader(HeaderData.SCHOOL_YEAR_HEADERS, row);
      rawOrgCode          = findHeader(HeaderData.ORD_CODE_HEADERS, row);
      rawRecNbr           = findHeader(HeaderData.REC_NUM_HEADERS, row);
      rawBirthDateIndex   = findHeader(HeaderData.BIRTH_DATE_HEADERS, row);
      rawFirstNameIndex   = findHeader(HeaderData.FIRST_NAME_HEADERS, row);
      rawGradeIndex       = findHeader(HeaderData.GRADE_HEADERS, row);
      rawLastNameIndex    = findHeader(HeaderData.LAST_NAME_HEADERS, row);
      rawMiddleNameIndex  = findHeader(HeaderData.MIDDLE_NAME_HEADERS, row);
      rawTownCodeIndex    = findHeader(HeaderData.TOWN_CODE_HEADERS, row);
      rawDOBYear          = findHeader(HeaderData.DOB_YEAR_HEADERS, row);
      
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
}
