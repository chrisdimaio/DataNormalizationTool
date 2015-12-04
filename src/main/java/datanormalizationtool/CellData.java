package datanormalizationtool;

/**
 * Data structure to hold cell data.
 */
public class CellData {
  private Flag flag;
  private String value;
  
  public CellData(String val) {
    value = val;
    flag  = Flag.NO_FLAG;
  }
  
  /**
   * flag getter.
   * @return the flag of this cell. NO_FLAG means no flag has been set.
   */
  public Flag getFlag() {
    return flag;
  }
  
  /**
   * Method for setting cell flag.
   * @param flg cell flag value.
   */
  public void setFlag(Flag flg) {
    flag = flg;
  }
  
  /**
   * value getter.
   * @return the value of the cell.
   */
  public String getValue() {
    return value;
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
    return "'f:" + flag + " v:" + value + "'";
  }
}
