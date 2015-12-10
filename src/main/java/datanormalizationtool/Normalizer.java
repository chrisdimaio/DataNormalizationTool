package datanormalizationtool;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;

/**
 * Class to error check and clean data.
 */
public class Normalizer {

  /**
   * Error checks and cleans TableData data structures.
   * @param table data to be normalized.
   */
  public void normalize(TableData table) {
    removeDuplicates(table);
    cleanAndPopulateDates(table);
    cleanAndMapTownCodes(table);
    table.printTable();
  }
  
  private void cleanAndMapTownCodes(TableData table) {
    for (int i = 1; i < table.getRowCount(); i++) {
      CellData townCodeCell = table.getCell(i, DeseTable.COL_TOWNCODE);
      if (townCodeCell != null) {
        String townCode = townCodeCell.getValue();
        if (TownCodeMappings.isTownName(townCode)) {
          townCodeCell.setValue(TownCodeMappings.getTownCode(townCode));
        } else if(!TownCodeMappings.isTownCode(townCode)){
          townCodeCell.setFlag(Flag.UNKNOWN_TOWN);
        }
        System.out.println(townCodeCell.getValue());
      }
    }
  }
  
  private void cleanAndPopulateDates(TableData table) {
    for (int i = 1; i < table.getRowCount(); i++) {
      CellData dobCell = table.getCell(i, DeseTable.COL_DATEOFBIRTH);
      if (dobCell != null) {
        String date = dobCell.getValue();
        GregorianCalendar calendar = new GregorianCalendar(Locale.US);
        calendar.setTime(DateHandler.standardizeDates(date));
        int dobYear = calendar.get(GregorianCalendar.YEAR);
        CellData yearCell = new CellData(String.valueOf(dobYear));
        table.setCell(i, DeseTable.COL_DOB_YEAR, yearCell);
      }
    }
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
}

// DateHandler test dates.
//System.out.println(DateHandler.dates("07/04/2015"));
//System.out.println(DateHandler.dates("07-04-2015"));
//System.out.println(DateHandler.dates("07/04/15"));
//System.out.println(DateHandler.dates("07-04-15"));
//System.out.println(DateHandler.dates("July 4, 2014"));
//System.out.println(DateHandler.dates("May 5th, 1986"));
//System.out.println(DateHandler.dates("May 5TH, 1986"));
//System.out.println(DateHandler.dates("FEB 5, 04"));