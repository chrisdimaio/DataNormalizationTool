package datanormalizationtool;

/**
 * Class to error check and clean data.
 */
public class Normalizer {

  /**
   * Error checks and cleans TableData data structures.
   * @param table data to be normalized/
   */
  public void normalize(TableData table) {
    table.getCell(3, 5).setValue("Hello Govna!");
  }
}
