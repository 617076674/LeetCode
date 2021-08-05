package question0761_special_binary_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public String makeLargestSpecial(String S) {
    StringBuilder sb = new StringBuilder();
    List<String> list = new ArrayList<>();
    int start = 0, countOne = 0;
    for (int i = 0; i < S.length(); ++i) {
      countOne += S.charAt(i) == '1' ? 1 : -1;
      if (countOne == 0) {
        String str = S.substring(start + 1, i);
        list.add("1" + makeLargestSpecial(str) + "0");
        start = i + 1;
      }
    }
    Collections.sort(list);
    for (int i = list.size() - 1; i >= 0; --i) {
      sb.append(list.get(i));
    }
    return sb.toString();
  }

}