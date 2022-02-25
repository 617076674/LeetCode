package question0544;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public String findContestMatch(int n) {
    List<String> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      list.add("" + i);
    }
    while (list.size() > 1) {
      List<String> nextList = new ArrayList<>();
      int left = 0, right = list.size() - 1;
      while (left < right) {
        nextList.add("(" + list.get(left) + "," + list.get(right) + ")");
        left++;
        right--;
      }
      list = nextList;
    }
    return list.get(0);
  }

}