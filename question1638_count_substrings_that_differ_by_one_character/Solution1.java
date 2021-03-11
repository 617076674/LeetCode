package question1638_count_substrings_that_differ_by_one_character;

public class Solution1 {

  public int countSubstrings(String s, String t) {
    int result = 0;
    for (int left1 = 0; left1 < s.length(); left1++) {
      for (int right1 = left1; right1 < s.length(); right1++) {
        String s1 = s.substring(left1, right1 + 1);
        for (int left2 = 0; left2 < t.length(); left2++) {
          for (int right2 = left2 + s1.length() - 1; right2 < t.length(); right2++) {
            String s2 = t.substring(left2, right2 + 1);
            if (isSame(s1, s2)) {
              result++;
            }
          }
        }
      }
    }
    return result;
  }

  private boolean isSame(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    int diff = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (diff == 1) {
          return false;
        }
        diff++;
      }
    }
    return diff == 1;
  }

}