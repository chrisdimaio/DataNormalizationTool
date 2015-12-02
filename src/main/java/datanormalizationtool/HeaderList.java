package datanormalizationtool;

import java.util.ArrayList;
import java.util.List;

public class HeaderList extends ArrayList<String> {
  HeaderList(List<String> list) {
    super(list);
  }

  /**
   * Returns true if this list contains the specified string regardless of case. More formally,
   * returns true if and only if this list contains at least one string str
   * such that (o==null ? str==null : o.equalsIgnoreCase(str)).
   * @param str string whose presence in this list is to be tested
   *
   * @return  true if this list contains the specified String regardless of case
   */
  public boolean contains(String str) {
    return indexOf(str) >= 0;
  }

  private int indexOf(String str) {
    if (str == null) {
      for (int i = 0; i < this.size(); i++) {
        if (this.get(i) == null) {
          return i;
        }
      }
    } else {
      for (int i = 0; i < this.size(); i++) {
        if (str.equalsIgnoreCase(this.get(i))) {
          return i;
        }
      }
    }
    return -1;
  }
}
