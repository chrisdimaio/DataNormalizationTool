package datanormalizationtool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Misc. utils to use for testing.
 */
public abstract class TestUtils {
  public static final String TEST_RESOURCES_DIR = "./build/resources/test/generictabledatatests/";
  
  protected static String fileToString(String filePath) {
    File file = new File(filePath);
    byte[] buffer = new byte[(int)file.length()];
    
    try {
      FileInputStream stream = new FileInputStream(file);
      stream.read(buffer);
      stream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new String(buffer);
  }
  
  protected static void stringToFile(String data , String filePath) {
    File file = new File(filePath);
    byte[] buffer = data.getBytes();
    
    try {
      FileOutputStream stream = new FileOutputStream(file);
      stream.write(buffer);
      stream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
