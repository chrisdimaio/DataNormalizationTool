package datanormaliztiontool;

import java.io.File;
import java.io.FileInputStream;

/**
 * Misc. utils to use for testing.
 */
public class TestUtils {
  public static String fileToString(String filePath) {
    File file = new File(filePath);
    byte[] buffer = new byte[(int)file.length()];
    
    try {
      FileInputStream stream = new FileInputStream(file);
      stream.read(buffer);
      stream.close();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    return new String(buffer);
  }
}
