package question0291;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  private boolean result;

  private String[] map = new String[26];

  public boolean wordPatternMatch(String pattern, String s) {
    dfs(pattern, s, 0, 0);
    return result;
  }

  private void dfs(String pattern, String s, int patternIndex, int sIndex) {
    if (result) {
      return;
    }
    if (patternIndex == pattern.length()) {
      if (sIndex != s.length()) {
        return;
      }
      Set<String> set = new HashSet<>();
      int cnt = 0;
      for (String replace : map) {
        if (null != replace) {
          cnt++;
          set.add(replace);
        }
      }
      result = cnt == set.size();
      return;
    }
    if (sIndex == s.length()) {
      return;
    }
    if (map[pattern.charAt(patternIndex) - 'a'] == null) {
      for (int i = sIndex; i < s.length(); i++) {
        map[pattern.charAt(patternIndex) - 'a'] = s.substring(sIndex, i + 1);
        dfs(pattern, s, patternIndex + 1, i + 1);
        map[pattern.charAt(patternIndex) - 'a'] = null;
      }
    } else {
      if (sIndex + map[pattern.charAt(patternIndex) - 'a'].length() > s.length()) {
        return;
      }
      if (!s.startsWith(map[pattern.charAt(patternIndex) - 'a'], sIndex)) {
        return;
      }
      dfs(pattern, s, patternIndex + 1, sIndex + map[pattern.charAt(patternIndex) - 'a'].length());
    }
  }
}