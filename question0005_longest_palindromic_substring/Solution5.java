package question0005_longest_palindromic_substring;

public class Solution5 {

  public String longestPalindrome(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      sb.append("#").append(s.charAt(i));
    }
    sb.append("#");
    int maxRight = 0, center = 0, maxLen = 1, startPos = 0;
    int[] p = new int[sb.length()];
    for (int i = 0; i < sb.length(); i++) {
      if (i < maxRight) {
        int mirror = 2 * center - i;
        p[i] = Math.min(p[mirror], maxRight - i);
      }
      int left = i - (p[i] + 1), right = i + (p[i] + 1);
      while (left >= 0 && right < sb.length() && sb.charAt(left) == sb.charAt(right)) {
        left--;
        right++;
        p[i]++;
      }
      if (i + p[i] > maxRight) {
        maxRight = i + p[i];
        center = i;
      }
      if (p[i] > maxLen) {
        maxLen = p[i];
        startPos = (i - p[i]) / 2;
      }
    }
    return s.substring(startPos, startPos + maxLen);
  }

}
