package question1763_longest_nice_substring;

public class Solution {

  public String longestNiceSubstring(String s) {
    int[] map = new int[52];
    for (int i = 0; i < s.length(); i++) {
      map[getIndex(s.charAt(i))]++;
    }
    int index = -1;
    for (int i = 0; i < s.length(); i++) {
      if (map[(getIndex(s.charAt(i)) + 26) % 52] == 0) {
        index = i;
        break;
      }
    }
    if (index == -1) {
      return s;
    }
    String left = longestNiceSubstring(s.substring(0, index));
    String right = longestNiceSubstring(s.substring(index + 1));
    return left.length() >= right.length() ? left : right;
  }

  private static int getIndex(char c) {
    if (c >= 'a' && c <= 'z') {
      return c - 'a';
    }
    return c - 'A' + 26;
  }

}