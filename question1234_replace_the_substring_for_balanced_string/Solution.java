package question1234_replace_the_substring_for_balanced_string;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  private static Map<Character, Integer> map = new HashMap<>();

  static {
    map.put('Q', 0);
    map.put('W', 1);
    map.put('E', 2);
    map.put('R', 3);
  }

  public int balancedString(String s) {
    int[] count = new int[4];
    for (int i = 0; i < s.length(); i++) {
      count[map.get(s.charAt(i))]++;
    }
    if (count[0] == count[1] && count[1] == count[2] && count[2] == count[3]
        && count[3] == s.length() / 4) {
      return 0;
    }
    int[] window = new int[4];
    int left = 0, right = -1, result = s.length();
    while (right + 1 < s.length()) {
      right++;
      window[map.get(s.charAt(right))]++;
      if (judge(count, window, s.length() / 4)) {
        result = Math.min(result, right - left + 1);
        while (left <= right) {
          window[map.get(s.charAt(left))]--;
          left++;
          if (judge(count, window, s.length() / 4)) {
            result = Math.min(result, right - left + 1);
          } else {
            break;
          }
        }
      }

    }
    return result;
  }

  private static boolean judge(int[] count, int[] window, int limit) {
    for (int i = 0; i < count.length; i++) {
      if (count[i] - window[i] > limit) {
        return false;
      }
    }
    return true;
  }

}