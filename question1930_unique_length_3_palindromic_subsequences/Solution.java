package question1930_unique_length_3_palindromic_subsequences;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  public int countPalindromicSubsequence(String s) {
    Set<String> set = new HashSet<>();
    int[][] map = new int[s.length() + 1][26];
    // map[i] 指的是 [0, i - 1] 范围内的字母个数
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < 26; j++) {
        map[i + 1][j] = map[i][j];
      }
      map[i + 1][s.charAt(i) - 'a']++;
    }
    for (int i = 1; i < s.length() - 1; i++) {
      int[] map1 = map[i];
      for (int j = 0; j < 26; j++) {
        if (map1[j] > 0 && map[s.length()][j] - map[i + 1][j] > 0) {
          char c = (char) (j + 'a');
          StringBuilder sb = new StringBuilder();
          sb.append(c);
          sb.append(s.charAt(i));
          sb.append(c);
          set.add(sb.toString());
        }
      }
    }
    return set.size();
  }

}