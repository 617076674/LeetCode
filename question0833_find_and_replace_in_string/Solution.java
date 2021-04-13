package question0833_find_and_replace_in_string;

import java.util.Arrays;

public class Solution {

  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    int[] match = new int[S.length()];
    Arrays.fill(match, -1);

    for (int i = 0; i < indexes.length; i++) {
      int ix = indexes[i];
      if (S.substring(ix, ix + sources[i].length()).equals(sources[i])) {
        match[ix] = i;
      }
    }
    StringBuilder result = new StringBuilder();
    int i = 0;
    while (i < S.length()) {
      if (match[i] >= 0) {
        result.append(targets[match[i]]);
        i += sources[match[i]].length();
      } else {
        result.append(S.charAt(i++));
      }
    }
    return result.toString();
  }

}