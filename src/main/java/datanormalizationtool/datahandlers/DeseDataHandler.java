package datanormalizationtool.datahandlers;

import datanormalizationtool.TableData;
import java.io.File;

import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author cdimaio
 */
public class DeseDataHandler extends TableData {
  
  @Override
  public void loadData(File file, int sheetIndex) {
    
  }
  
  @Override
  protected boolean foundHeaderRow(Sheet sheet) {
    return false;
  }
}
