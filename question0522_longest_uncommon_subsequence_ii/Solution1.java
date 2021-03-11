package question0522_longest_uncommon_subsequence_ii;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

  public int findLUSlength(String[] strs) {
    Set<String>[] sets = new Set[strs.length];
    for (int i = 0; i < strs.length; i++) {
      sets[i] = new HashSet<>();
      fillSet(strs[i], 0, new StringBuilder(), sets[i]);
    }
    int max = -1;
    for (int i = 0; i < strs.length; i++) {
      Set<String> set = sets[i];
      for (String s : set) {
        if (s.length() > max) {
          boolean flag = true;
          for (int j = 0; j < strs.length; j++) {
            if (j != i) {
              if (sets[j].contains(s)) {
                flag = false;
                break;
              }
            }
          }
          if (flag) {
            max = Math.max(max, s.length());
          }
        }
      }
    }
    return max;
  }

  private void fillSet(String s, int index, StringBuilder sb, Set<String> set) {
    if (index == s.length()) {
      set.add(sb.toString());
      return;
    }
    sb.append(s.charAt(index));
    fillSet(s, index + 1, sb, set);
    sb.deleteCharAt(sb.length() - 1);
    fillSet(s, index + 1, sb, set);
  }

}