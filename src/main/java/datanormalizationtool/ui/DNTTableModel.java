package datanormalizationtool.ui;

import datanormalizationtool.CellData;
import datanormalizationtool.TableData;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cdimaio
 */
public class DNTTableModel extends AbstractTableModel {
  private final TableData data;
  
  public DNTTableModel(TableData tableData) {
    data = tableData;
  }

  @Override
  public int getColumnCount() {
    return data.getColumnCount();
  }

  @Override
  public String getColumnName(int column) {
    return data.getCell(0, column).getValue();
  }

  @Override
  public int getRowCount() {
    return data.getRowCount() - 1;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Object result = null;

    CellData cell = data.getCell(rowIndex + 1, columnIndex);
    if (cell != null) {
      result = cell.getValue();
    }

    return result;
  }

  public CellData getCell(int row, int col) {
    return data.getCell(row + 1, col);
  }
}
