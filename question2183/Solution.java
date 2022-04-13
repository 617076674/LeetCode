package question2183;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public long coutPairs(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int key = gcd(nums[i], k);
      map.put(key, map.getOrDefault(key, 0) + 1);
    }
    long result = 0;
    for (Map.Entry<Integer, Integer> entry1 : map.entrySet()) {
      for (Map.Entry<Integer, Integer> entry2 : map.entrySet()) {
        if (1L * entry1.getKey() * entry2.getKey() % k == 0) {
          if (entry1.getKey().equals(entry2.getKey())) {
            result += 1L * entry1.getValue() * (entry2.getValue() - 1) / 2;
          } else if (entry1.getKey() < entry2.getKey()){
            result += 1L * entry1.getValue() * entry2.getValue();
          }
        }
      }
    }
    return result;
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

}