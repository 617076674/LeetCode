package question1726_tuple_with_same_product;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int tupleSameProduct(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int tmp = nums[i] * nums[j];
        map.put(tmp, map.getOrDefault(tmp, 0) + 1);
      }
    }
    int result = 0;
    for (int value : map.values()) {
      result += value * (value - 1) * 2 * 2;
    }
    return result;
  }

}