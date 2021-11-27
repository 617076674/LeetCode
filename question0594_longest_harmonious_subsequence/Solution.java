package question0594_longest_harmonious_subsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int findLHS(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int result = 0;
    for (int num : nums) {
      Integer less = map.get(num - 1), greater = map.get(num + 1);
      if (less != null || greater != null) {
        result = Math.max(result,
            Math.max(less == null ? 0 : less, greater == null ? 0 : greater)
                + map.get(num));
      }
    }
    return result;
  }

}