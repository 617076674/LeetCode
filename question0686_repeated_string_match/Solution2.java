package question0686_repeated_string_match;

/**
 * KMP
 */
public class Solution2 {

  public int repeatedStringMatch(String a, String b) {
    int[] next = getNext(b);
    int i = 0, j = 0;
    boolean match = false;
    for (; i - j < a.length(); i++) {
      while (j > 0 && a.charAt(i % a.length()) != b.charAt(j)) {
        j = next[j - 1];
      }
      if (a.charAt(i % a.length()) == b.charAt(j)) {
        j++;
      }
      if (j == b.length()) {
        match = true;
        break;
      }
    }
    if (!match) {
      return -1;
    }
    return i / a.length() + 1;
  }

  private static int[] getNext(String s) {
    // 字符串 s[0,i] 中最长相同前后缀的长度为 next[i]
    int[] next = new int[s.length()];
    for (int i = 1; i < next.length; i++) {
      int j = next[i - 1];
      while (j > 0 && s.charAt(i) != s.charAt(j)) {
        j = next[j - 1];
      }
      if (s.charAt(i) == s.charAt(j)) {
        next[i] = j + 1;
      }
    }
    return next;
  }

}
