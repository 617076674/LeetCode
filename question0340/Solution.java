package question0340;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> window = new HashMap<>();
    int result = 0, left = 0, right = -1;
    while (right + 1 < s.length()) {
      right++;
      window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
      while (window.keySet().size() > k) {
        int cntLeft = window.get(s.charAt(left));
        if (cntLeft == 1) {
          window.remove(s.charAt(left));
        } else {
          window.put(s.charAt(left), cntLeft - 1);
        }
        left++;
      }
      result = Math.max(result, right - left + 1);
    }
    return result;
  }

}