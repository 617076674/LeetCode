package question2100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<Integer> goodDaysToRobBank(int[] security, int time) {
    if (time == 0) {
      List<Integer> result = new ArrayList<>();
      for (int i = 0; i < security.length; i++) {
        result.add(i);
      }
      return result;
    }
    boolean[] checkLeft = new boolean[security.length];
    int preDown = 0;
    for (int i = 1; i < security.length; i++) {
      if (security[i] > security[i - 1]) {
        preDown = 0;
      } else {
        preDown++;
      }
      if (preDown >= time) {
        checkLeft[i] = true;
      }
    }
    boolean[] checkRight = new boolean[security.length];
    preDown = 0;
    for (int i = security.length - 2; i >= 0; i--) {
      if (security[i] > security[i + 1]) {
        preDown = 0;
      } else {
        preDown++;
      }
      if (preDown >= time) {
        checkRight[i] = true;
      }
    }
    boolean[] checkMid = new boolean[security.length];
    Arrays.fill(checkMid, true);
    for (int i = 1; i < checkLeft.length - 1; i++) {
      if (security[i] > security[i - 1] || security[i] > security[i + 1]) {
        checkMid[i] = false;
      }
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < security.length; i++) {
      if (checkLeft[i] && checkRight[i] && checkMid[i]) {
        result.add(i);
      }
    }
    return result;
  }

}