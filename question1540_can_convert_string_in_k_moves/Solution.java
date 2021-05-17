package question1540_can_convert_string_in_k_moves;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public boolean canConvertString(String s, String t, int k) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (t.charAt(i) == s.charAt(i)) {
        continue;
      }
      int operation = (t.charAt(i) - s.charAt(i) + 26) % 26;
      map.put(operation, map.getOrDefault(operation, 0) + 1);
    }
    int maxCount = k / 26;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int tempMaxCount = maxCount;
        if (k % 26 >= entry.getKey()) {
            tempMaxCount++;
        }
        if (tempMaxCount < entry.getValue()) {
            return false;
        }
    }
    return true;
  }

}