package question1931_painting_a_grid_with_three_different_colors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  private static final int MOD = 1000000007;

  private int[][] dp;

  private Map<Integer, Set<Integer>> map = new HashMap<>();

  private int m;

  public int colorTheGrid(int m, int n) {
    dp = new int[n][(int) Math.pow(3, m)];
    this.m = m;
    for (int i = 0; i < dp[0].length; i++) {
      if (!check(i)) {
        continue;
      }
      for (int j = i + 1; j < dp[0].length; j++) {
        if (check(j) && check(i, j)) {
          add2Map(i, j);
          add2Map(j, i);
        }
      }
    }
    for (int j = 0; j < dp[0].length; j++) {
      if (check(j)) {
        dp[0][j] = 1;
      }
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (!check(j)) {
          continue;
        }
        for (int status : map.get(j)) {
          dp[i][j] += dp[i - 1][status];
          dp[i][j] %= MOD;
        }
      }
    }
    int result = 0;
    for (int i = 0; i < dp[0].length; i++) {
      result += dp[n - 1][i];
      result %= MOD;
    }
    return result;
  }

  private void add2Map(int i, int j) {
    Set<Integer> set = map.get(i);
    if (null == set) {
      set = new HashSet<>();
      set.add(j);
      map.put(i, set);
      return;
    }
    set.add(j);
  }

  private boolean check(int num) {
    String s = num2String(num);
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        return false;
      }
    }
    return true;
  }

  private boolean check(int num1, int num2) {
    String s1 = num2String(num1), s2 = num2String(num2);
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) == s2.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  private String num2String(int num) {
    StringBuilder sb = new StringBuilder();
    while (num > 0) {
      sb.append(num % 3);
      num /= 3;
    }
    while (sb.length() < m) {
      sb.append("0");
    }
    return sb.reverse().toString();
  }

}