package datanormalizationtool.ui;

import datanormalizationtool.Error;
import datanormalizationtool.TableData;
import datanormalizationtool.Warning;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.table.AbstractTableModel;

import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.JXTable;

/**
 *
 * @author cdimaio
 */
public class DNTTable extends JXTable {
  private final TableData data;
  
  public DNTTable(AbstractTableModel model, TableData tableData) {
    super(model);
    data = tableData;
  }
  
  @Override
  public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
    Component comp = super.prepareRenderer(renderer, row, col);

    if (data.getCell(row + 1, col).getError() != Error.NO_ERROR) {
      comp.setBackground(Color.RED);
    }

    if (data.getCell(row + 1, col).getWarning() != Warning.NO_WARNING) {
      comp.setBackground(Color.YELLOW);
    }

    return comp;
  }

  @Override
  public String getToolTipText(MouseEvent event) {
    String tip = null;
    Point p = event.getPoint();

    int row = rowAtPoint(p);
    int col = columnAtPoint(p);

    try {
      DNTTableModel model = (DNTTableModel)getModel();
      tip = model.getCell(row, col).getError().toString();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return tip;
  }
}
