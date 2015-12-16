package datanormalizationtool;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Data structure to hold cell data.
 */
public class CellData {
  private String value;
  
  private final LinkedList<Error> errors = new LinkedList<Error>();
  private final LinkedList<Warning> warnings = new LinkedList<Warning>();
  
  /**
   * Creates CellData instance with specified value.
   * @param val value of CellData instance.
   */
  public CellData(String val) {
    value   = val;
  }
  
  public void addError(Error err) {
    errors.add(err);
  }

  public void addWarning(Warning warn) {
    warnings.add(warn);
  }
  
  public boolean equals(CellData cell) {
    return value.equalsIgnoreCase(cell.getValue()) 
            && errors.equals(cell.getErrorList())
            && warnings.equals(cell.getWarningList());
  }
  
  public boolean hasErrors() {
    return !errors.isEmpty();
  }
  
  public boolean hasWarnings() {
    return !warnings.isEmpty();
  }
  
  public LinkedList<Error> getErrorList() {
    return errors;
  }
  
  /**
   * value getter.
   * @return the value of the cell.
   */
  public String getValue() {
    return value;
  }
  
  public LinkedList<Warning> getWarningList() {
    return warnings;
  }
  
  /**
   * Method for setting cell value.
   * @param val cell flag value.
   */
  public void setValue(String val) {
    value = val;
  }
  
  /**
   * Returns string representation of this cell.
   * @return a string representation of this cell.
   */
  @Override
   public String toString() {
    String returnVal = "v: " + value;
    returnVal += "e: ";
    
    Iterator<Error> errorIt = errors.iterator();
    while(errorIt.hasNext()) {
      returnVal += errorIt.next();
      returnVal += errorIt.hasNext() ? "," : "";
    }
    returnVal += "w: ";
    Iterator<Warning> warningIt = warnings.iterator();
    while(warningIt.hasNext()) {
      returnVal += warningIt.next();
      returnVal += warningIt.hasNext() ? "," : "";
    }
    
    return returnVal;
  }
}
