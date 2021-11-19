package question1520_maximum_number_of_non_overlapping_substrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  private int[][] realMap = new int[26][2];

  public List<String> maxNumOfSubstrings(String s) {
    for (int i = 0; i < realMap.length; i++) {
      realMap[i][0] = realMap[i][1] = -1;
    }
    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - 'a';
      if (realMap[index][0] == -1) {
        realMap[index][0] = realMap[index][1] = i;
      } else {
        realMap[index][1] = i;
      }
    }
    for (int i = 0; i < realMap.length; i++) {
      if (realMap[i][0] == -1) {
        continue;
      }
      for (int j = realMap[i][0]; j <= realMap[i][1]; j++) {
        int index = s.charAt(j) - 'a';
        if (realMap[i][0] <= realMap[index][0] && realMap[i][1] >= realMap[index][1]) {
          continue;
        }
        realMap[i][0] = Math.min(realMap[i][0], realMap[index][0]);
        realMap[i][1] = Math.max(realMap[i][1], realMap[index][1]);
        j = realMap[i][0] - 1;
      }
    }
    Arrays.sort(realMap, (p1, p2) -> {
      if (p1[1] == p2[1]) {
        return p2[0] - p1[0];
      }
      return p1[1] - p2[1];
    });
    List<String> result = new ArrayList<>();
    int end = -1;
    for (int[] p : realMap) {
      if (p[0] == -1) {
        continue;
      }
      if (end == -1 || p[0] > end) {
        end = p[1];
        result.add(s.substring(p[0], p[1] + 1));
      }
    }
    return result;
  }

}