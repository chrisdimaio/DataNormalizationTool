package datanormalizationtool;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
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

  public void loadData(final File file) {
    Workbook workbook;
    Sheet sheet = null;

    try {
      FileInputStream inputStream = new FileInputStream(file);
      workbook = new XSSFWorkbook(inputStream);
      sheet = workbook.getSheetAt(0);
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (sheet != null && findHeaderRow(sheet)) {
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

      Row row;
      for (int r = headerRowIndex + 1; r < sheet.getLastRowNum(); r++) {
        row = sheet.getRow(r);
        setCell(r, COL_FIRSTNAME, cellToString(row.getCell(rawFirstNameIndex)));
        setCell(r, COL_LASTNAME, cellToString(row.getCell(rawLastNameIndex)));
        setCell(r, COL_MIDDLENAME, cellToString(row.getCell(rawMiddleNameIndex)));
        setCell(r, COL_DATEOFBIRTH, cellToString(row.getCell(rawBirthDateIndex)));
        setCell(r, COL_TOWNCODE, cellToString(row.getCell(rawTownCodeIndex)));
        setCell(r, COL_GRADE, cellToString(row.getCell(rawGradeIndex)));
      }
    } else {
      System.out.println("No header row found.");
    }
  }

  private boolean findHeaderRow(Sheet sheet) {
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

  private int findHeader(HeaderList headerList, Row row) {
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
}