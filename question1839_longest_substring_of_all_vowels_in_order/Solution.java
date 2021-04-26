package question1839_longest_substring_of_all_vowels_in_order;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int longestBeautifulSubstring(String word) {
    int result = 0, left = 0, right = -1;
    Map<Character, Integer> window = new HashMap<>();
    while (right + 1 < word.length()) {
      right++;
      if (right > left && word.charAt(right) < word.charAt(right - 1)) {
        left = right;
        right = left - 1;
        window.clear();
        continue;
      }
      window.put(word.charAt(right), window.getOrDefault(word.charAt(right), 0) + 1);
      if (window.size() == 5) {
        result = Math.max(result, right - left + 1);
      }
    }
    return result;
  }

}