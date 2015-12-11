package datanormalizationtool;

/**
 * Data structure to hold cell data.
 */
public class CellData {
  private Flag flag;
  private String value;
  private Warning warning;
  
  public CellData(String val) {
    flag    = Flag.NO_FLAG;
    value   = val;
    warning = Warning.NO_WARNING;
  }
  
  public boolean equals(CellData cell) {
    return value.equalsIgnoreCase(cell.getValue()) && flag.equals(cell.getFlag());
  }
  
  /**
   * flag getter.
   * @return the flag of this cell. NO_FLAG means no flag has been set.
   */
  public Flag getFlag() {
    return flag;
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
   * @param flg cell flag value.
   */
  public void setFlag(Flag flg) {
    flag = flg;
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
    return "{f:" + flag + ", w: " + warning + ", v: '" + value + "'}";
  }
}
