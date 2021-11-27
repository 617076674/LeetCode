package question1745;

import java.util.Arrays;

public class Solution {

  public boolean checkPartitioning(String s) {
    // dp[i][j] 表示字符串 s 中 [i - 1, j - 1] 范围内的子串是否是一个回文串
    boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
    Arrays.fill(dp[0], true);
    for (int i = 1; i < dp.length; i++) {
      dp[i][0] = true;
    }
    for (int gap = 0; gap >= -s.length(); gap--) {
      for (int i = 1; i <= s.length() + gap; i++) {
        int j = i - gap;
        if (i == j) {
          dp[i][j] = true;
        } else if (s.charAt(i - 1) != s.charAt(j - 1)) {
          dp[i][j] = false;
        } else {
          dp[i][j] = j - i == 1 || dp[i + 1][j - 1];
        }
      }
    }
    for (int line1 = 0; line1 < s.length() - 1; line1++) {
      // [0, line1] 是第一个回文串
      if (!dp[1][line1 + 1]) {
        continue;
      }
      for (int line2 = line1 + 1; line2 < s.length() - 1; line2++) {
        // [line1 + 1, line2] 是第二个回文串，[line2 + 1, s.length() - 1] 是第三个回文串
        if (dp[line1 + 2][line2 + 1] && dp[line2 + 2][s.length()]) {
          return true;
        }
      }
    }
    return false;
  }

}