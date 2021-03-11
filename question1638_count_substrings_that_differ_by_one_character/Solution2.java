package question1638_count_substrings_that_differ_by_one_character;

public class Solution2 {

    public int countSubstrings(String s, String t) {
      int result = 0;
      for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < t.length(); j++) {
          if (s.charAt(i) != t.charAt(j)) {
            int left = 1, right = 1;
            while (i + right < s.length() && j + right < t.length() && s.charAt(i + right) == t.charAt(j + right)) {
              right++;
            }
            while (i - left >= 0 && j - left >= 0 && s.charAt(i - left) == t.charAt(j - left)) {
              left++;
            }
            result += left * right;
          }
        }
      }
      return result;
    }

}