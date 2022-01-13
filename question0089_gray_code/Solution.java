package question0089_gray_code;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> grayCode(int n) {
    List<String> grayCodeList = grayCodeHelper(n);
    List<Integer> result = new ArrayList<>();
    for (String grayCode : grayCodeList) {
      result.add(string2Int(grayCode));
    }
    return result;
  }

  private static int string2Int(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      result = result * 2 + s.charAt(i) - '0';
    }
    return result;
  }

  private static List<String> grayCodeHelper(int n) {
    List<String> result = new ArrayList<>();
    if (n == 1) {
      result.add("0");
      result.add("1");
      return result;
    }
    List<String> preList = grayCodeHelper(n - 1);
    for (int i = 0; i < preList.size(); i++) {
      result.add("0" + preList.get(i));
    }
    for (int i = preList.size() - 1; i >= 0; i--) {
      result.add("1" + preList.get(i));
    }
    return result;
  }

}