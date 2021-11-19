package question0165_compare_version_numbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int compareVersion(String version1, String version2) {
    List<Integer> list1 = changeToArray(version1), list2 = changeToArray(version2);
    for (int i = 0; i < list1.size() || i < list2.size(); i++) {
      int num1 = 0, num2 = 0;
      if (i < list1.size() && i < list2.size()) {
        num1 = list1.get(i);
        num2 = list2.get(i);
      } else if (i < list1.size() && i >= list2.size()) {
        num1 = list1.get(i);
      } else if (i >= list1.size() && i < list2.size()) {
        num2 = list2.get(i);
      }
      if (num1 > num2) {
        return 1;
      } else if (num1 < num2) {
        return -1;
      }
    }
    return 0;
  }

  private List<Integer> changeToArray(String version) {
    List<Integer> list = new ArrayList<>();
    String[] strings = version.split("\\.");
    for (String string : strings) {
      list.add(Integer.parseInt(string));
    }
    return list;
  }

}