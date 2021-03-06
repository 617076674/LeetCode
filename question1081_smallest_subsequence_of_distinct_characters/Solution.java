package question1081_smallest_subsequence_of_distinct_characters;

/**
 * 和 question0316 相同。
 */
public class Solution {

  public String smallestSubsequence(String s) {
    boolean[] visited = new boolean[26];
    int[] map = new int[26];
    for (int i = 0; i < s.length(); i++) {
      map[s.charAt(i) - 'a']++;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!visited[c - 'a']) {
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
          if (map[sb.charAt(sb.length() - 1) - 'a'] > 0) {
            visited[sb.charAt(sb.length() - 1) - 'a'] = false;
            sb.deleteCharAt(sb.length() - 1);
          } else {
            break;
          }
        }
        visited[c - 'a'] = true;
        sb.append(c);
      }
      map[c - 'a']--;
    }
    return sb.toString();
  }

}