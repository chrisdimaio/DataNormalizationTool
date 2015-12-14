package datanormalizationtool;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;

/**
 * Class to error check and clean data.
 */
public class Normalizer {
  private static final int FLAG_AGE_LIMIT    = 24;
  private static final int WARNING_AGE_LIMIT = 18;
  
  /**
   * Error checks and cleans TableData data structures.
   * @param table data to be normalized.
   */
  public void normalize(TableData table) {
    removeDuplicates(table);
    cleanAndPopulateDates(table);
    cleanAndMapTownCodes(table);
    cleanAndValidateGrades(table);
    compareAgeToGrade(table);
    checkForEmptyCells(table, DeseTable.COL_MIDDLENAME);
    table.removeEmptyRows();
  }
  
  private void checkForEmptyCells(TableData table, int columnIndex) {
    for (int i = 1; i < table.getRowCount(); i++) {
      CellData cell = table.getCell(i, columnIndex);
      if (workableCell(cell) && cell.getValue().equals("")) {
        cell.setError(Error.NO_MIDDLE_NAME);
      }
    }
  }
  
  private void compareAgeToGrade(TableData table) {
    for (int i = 1; i < table.getRowCount(); i++) {
      CellData dobCell = table.getCell(i, DeseTable.COL_DATEOFBIRTH);
      CellData gradeCell = table.getCell(i, DeseTable.COL_GRADE);
      if (workableCell(dobCell) && workableCell(gradeCell)) {
        String grade = gradeCell.getValue();
        int age         = DateHandler.calculateAgeInMonths(dobCell.getValue());
        int expectedAge = GradeMappings.getAge(grade);
        int ageDelta    = Math.abs(age - expectedAge);
        if (ageDelta > WARNING_AGE_LIMIT) {
          dobCell.setWarning(Warning.AGE_GRADE_MISMATCH);
          gradeCell.setWarning(Warning.AGE_GRADE_MISMATCH);
        } else if (ageDelta > FLAG_AGE_LIMIT) {
          dobCell.setError(Error.AGE_GRADE_MISMATCH);
          gradeCell.setError(Error.AGE_GRADE_MISMATCH);
        }
      }
    }
  }
  
  private void cleanAndValidateGrades(TableData table) {
    for (int i = 1; i < table.getRowCount(); i++) {
      CellData gradeCodeCell = table.getCell(i, DeseTable.COL_GRADE);
      if (gradeCodeCell != null) {
        String gradeCode = gradeCodeCell.getValue();
        if (GradeMappings.isGradeName(gradeCode)) {
          gradeCodeCell.setValue(GradeMappings.getGradeCode(gradeCode));
        } else if (!GradeMappings.isGradeCode(gradeCode)) {
          gradeCodeCell.setError(Error.UNKNOWN_GRADE);
        }
      }
    }
  }
  
  private void cleanAndMapTownCodes(TableData table) {
    for (int i = 1; i < table.getRowCount(); i++) {
      CellData townCodeCell = table.getCell(i, DeseTable.COL_TOWNCODE);
      if (townCodeCell != null) {
        String townCode = townCodeCell.getValue();
        if (TownCodeMappings.isTownName(townCode)) {
          townCodeCell.setValue(TownCodeMappings.getTownCode(townCode));
        } else if (!TownCodeMappings.isTownCode(townCode)) {
          townCodeCell.setError(Error.UNKNOWN_TOWN);
        }
      }
    }
  }
  
  private void cleanAndPopulateDates(TableData table) {
    for (int i = 1; i < table.getRowCount(); i++) {
      CellData dobCell = table.getCell(i, DeseTable.COL_DATEOFBIRTH);
      if (dobCell != null) {
        String date = dobCell.getValue();
        GregorianCalendar calendar = new GregorianCalendar(Locale.US);
        Date dob = DateHandler.standardizeDate(date);
        dobCell.setValue(DateHandler.formatDate(dob));
        calendar.setTime(dob);
        int dobYear = calendar.get(GregorianCalendar.YEAR);
        CellData yearCell = new CellData(String.valueOf(dobYear));
        table.setCell(i, DeseTable.COL_DOB_YEAR, yearCell);
      }
    }
  }
  
  private boolean compareRows(Map<Integer, CellData> rowA, Map<Integer, CellData> rowB) {
    boolean same = true;
    if (rowA.isEmpty() || rowB.isEmpty()) {
      return false;
    }
    for (int i = 0; i < DeseTable.COLUMN_COUNT; i++) {
      CellData cellA = rowA.get(i);
      CellData cellB = rowB.get(i);
      same = same && cellA.equals(cellB);
      if (!same) {
        return false;
      }
    }
    return same;
  }
  
  // Test the shit out of this. Might want to change access level to allow unit tests.
  private void removeDuplicates(TableData table) {
    Map<Integer, CellData> row;
    for (int r = 1; r < DeseTable.COLUMN_COUNT; r++) {
      row = table.getRow(r);
      int rowCount = table.getRowCount();
      for (int i = 0; i < rowCount; i++) {
        if (compareRows(row, table.getRow(i)) && i != r) {
          table.removeRow(i);
        }
      }
    }
  }
  
  private void removeEmptyRows(TableData table) {
    table.removeEmptyRows();
  }
  
  // Reason behind this method needs to be revisited.
  private boolean workableCell(CellData cell) {
    return cell != null 
            && cell.getError() == Error.NO_FLAG 
            && cell.getWarning() == Warning.NO_WARNING;
  }
}