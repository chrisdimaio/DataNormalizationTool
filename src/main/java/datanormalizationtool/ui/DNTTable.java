package datanormalizationtool.ui;

import datanormalizationtool.CellData;
import datanormalizationtool.Error;
import datanormalizationtool.TableData;
import datanormalizationtool.Warning;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.table.AbstractTableModel;

import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.Highlighter;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author cdimaio
 */
public class DNTTable extends JXTable {
  private final TableData data;
  
  public DNTTable(AbstractTableModel model, TableData tableData) {
    super(model);
    
    Highlighter highlighter = HighlighterFactory.createAlternateStriping();
    setHighlighters(highlighter);
    
    data = tableData;
  }
  
  @Override
  public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
    Component comp = super.prepareRenderer(renderer, row, col);

    if (data.getCell(row + 1, col).hasErrors()) {
      comp.setBackground(Color.RED);
    }

    if (data.getCell(row + 1, col).hasWarnings()) {
      comp.setBackground(Color.YELLOW);
    }

    return comp;
  }

  @Override
  public String getToolTipText(MouseEvent event) {
    Point p = event.getPoint();
    int row = rowAtPoint(p);
    int col = columnAtPoint(p);
    DNTTableModel model = (DNTTableModel)getModel();
    CellData cell = model.getCell(row, col);

    if (cell.hasErrors() || cell.hasWarnings()) {
      String tip = "<html>";
      if (cell.hasErrors()) {
        Iterator<Error> errorIt= cell.getErrorList().iterator();
        tip += "Errors:<br>";
        while (errorIt.hasNext()) {
          tip += errorIt.next() + "<br>";
        }
      }

      if (cell.hasWarnings()) {
        Iterator<Warning> warningIt= cell.getWarningList().iterator();
        tip += "Warnings:<br>";
        while (warningIt.hasNext()) {
          tip += warningIt.next() + "<br>";
        }
      }
      return tip + "</html>";
    }
    return null;
  }
}
