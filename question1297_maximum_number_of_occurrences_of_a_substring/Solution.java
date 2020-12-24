package question1297_maximum_number_of_occurrences_of_a_substring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i <= s.length() - minSize; i++) {
      String substring = s.substring(i, i + minSize);
      if (isValid(substring, maxLetters)) {
        map.put(substring, map.getOrDefault(substring, 0) + 1);
      }
    }
    int result = 0;
    for (int num : map.values()) {
      result = Math.max(num, result);
    }
    return result;
  }

  private boolean isValid(String s, int maxLetters) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      set.add(s.charAt(i));
    }
    return set.size() <= maxLetters;
  }

}