package datanormalizationtool.datahandlers;

import datanormalizationtool.TableData;

import java.io.File;
import java.util.LinkedList;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * Class for loading and understanding DESE forms.
 */
public class DeseInitialDataHandler extends TableData {
    
  @Override
  public void loadData(File file, int sheetIndex) {
    Workbook workbook = readWorkbook(file);
    
    System.out.println(findSheet(SheetPatterns.ADDITIONS, workbook).getSheetName());
    System.out.println(findSheet(SheetPatterns.INITIAL, workbook).getSheetName());
    
  }
  
  @Override
  protected boolean foundHeaderRow(Sheet sheet) {
    return false;
  }
}
