package question1542;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int longestAwesome(String s) {
    int[] status2Index = new int[1024];
    int status = 0;
    for (int i = 0; i < s.length(); i++) {
      int digit = s.charAt(i) - '0';
      status ^= (1 << digit);
      status2Index[status] = i;
    }
    Set<Integer>[] matchSet = new HashSet[1024];
    for (int i = 0; i < 1024; i++) {
      for (int j = i; j < 1024; j++) {
        int temp = i ^ j;
        if (temp == 0 || (temp & (temp - 1)) == 0) {
          if (null == matchSet[i]) {
            matchSet[i] = new HashSet<>();
          }
          matchSet[i].add(j);
          if (null == matchSet[j]) {
            matchSet[j] = new HashSet<>();
          }
          matchSet[j].add(i);
        }
      }
    }
    int result = 0;
    status = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int anotherStatus : matchSet[status]) {
        result = Math.max(result, status2Index[anotherStatus] - i + 1);
      }
      int digit = s.charAt(i) - '0';
      status ^= (1 << digit);
    }
    return result;
  }

}