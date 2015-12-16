package datanormalizationtool;

/**
 * Data structure to hold cell data.
 */
public class CellData {
  private Error error;
  private String value;
  private Warning warning;
  
  /**
   * Creates CellData instance with specified value.
   * @param val value of CellData instance.
   */
  public CellData(String val) {
    error   = Error.NO_ERROR;
    value   = val;
    warning = Warning.NO_WARNING;
  }
  
  public boolean equals(CellData cell) {
    return value.equalsIgnoreCase(cell.getValue()) && error.equals(cell.getError());
  }
  
  /**
   * flag getter.
   * @return the flag of this cell. NO_FLAG means no flag has been set.
   */
  public Error getError() {
    return error;
  }
  
  /**
   * value getter.
   * @return the value of the cell.
   */
  public String getValue() {
    return value;
  }
  
  /**
   * warning getter.
   * @return the warning of this cell. NO_WARNING mean no flag has been set.
   */
  public Warning getWarning() {
    return warning;
  }
  
  /**
   * Method for setting cell flag.
   * @param err cell flag value.
   */
  public void setError(Error err) {
    error = err;
  }
  
  /**
   * Method for setting cell value.
   * @param val cell flag value.
   */
  public void setValue(String val) {
    value = val;
  }
  
  /**
   * Method for setting cell warning.
   * @param warn cell warning value;
   */
  public void setWarning(Warning warn) {
    warning = warn;
  }
  
  /**
   * Returns string representation of this cell.
   * @return a string representation of this cell.
   */
  @Override
  public String toString() {
    return "{f:" + error + ", w: " + warning + ", v: '" + value + "'}";
  }
}
