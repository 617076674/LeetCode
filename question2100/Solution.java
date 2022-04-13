package question2100;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> goodDaysToRobBank(int[] security, int time) {
    int[] left = new int[security.length];
    int cnt = 0;
    for (int i = 1; i < security.length; i++) {
      if (security[i] <= security[i - 1]) {
        cnt++;
      } else {
        cnt = 0;
      }
      left[i] = cnt;
    }
    int[] right = new int[security.length];
    cnt = 0;
    for (int i = security.length - 2; i >= 0; i--) {
      if (security[i] <= security[i + 1]) {
        cnt++;
      } else {
        cnt = 0;
      }
      right[i] = cnt;
    }
    List<Integer> result = new ArrayList<>();
    for (int i = time; i < security.length - time; i++) {
      // [len - time - 1, len - 1] len - 1 - len + time + 1
      if (left[i] >= time && right[i] >= time) {
        result.add(i);
      }
    }
    return result;
  }

}