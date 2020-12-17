package question0140_word_break_ii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {

  public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    int n = s.length();
    //dp[i][j]表示[i, j]子串被分割的结果
    Set<String>[][] dp = new HashSet[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = new HashSet<>();
        if (i == j) {
          String str = s.substring(i, i + 1);
          if (set.contains(str)) {
            dp[i][i].add(str);
          }
        }
      }
    }
    for (int gap = -1; gap >= -n + 1; gap--) {
      for (int i = 0; i <= gap + n - 1; i++) {
        String str = s.substring(i, i - gap + 1);
        if (set.contains(str)) {
          dp[i][i - gap].add(str);
        }
        for (int j = -gap - 1; j >= 0; j--) {
          Set<String> set1 = dp[i][i + j];
          Set<String> set2 = dp[i + j + 1][i - gap];
          for (String str1 : set1) {
            for (String str2 : set2) {
              dp[i][i - gap].add(str1 + " " + str2);
            }
          }
        }
      }
    }
    return new ArrayList<>(dp[0][n - 1]);
  }

}