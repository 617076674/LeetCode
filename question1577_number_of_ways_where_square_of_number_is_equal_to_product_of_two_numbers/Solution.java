package question1577_number_of_ways_where_square_of_number_is_equal_to_product_of_two_numbers;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int numTriplets(int[] nums1, int[] nums2) {
    Map<Long, Long> map1 = generateMap(nums1);
    Map<Long, Long> map2 = generateMap(nums2);
    return (int) (numTripletsHelper(map1, map2) + numTripletsHelper(map2, map1));
  }

  private static Map<Long, Long> generateMap(int[] nums) {
    Map<Long, Long> map = new HashMap<>();
    for (long num : nums) {
      map.put(num, map.getOrDefault(num, 0L) + 1);
    }
    return map;
  }

  private long numTripletsHelper(Map<Long, Long> map1, Map<Long, Long> map2) {
    long result1 = 0, result2 = 0;
    for (Map.Entry<Long, Long> entry1 : map1.entrySet()) {
      long target = entry1.getKey() * entry1.getKey();
      for (Map.Entry<Long, Long> entry2 : map2.entrySet()) {
        long num1 = entry2.getKey();
        if (target % num1 == 0) {
          long num2 = target / num1;
          if (num1 == num2) {
            result1 += entry1.getValue() * entry2.getValue() * (entry2.getValue() - 1) / 2;
          } else {
            Long num2Cnt = map2.get(num2);
            if (null != num2Cnt) {
              result2 += entry1.getValue() * entry2.getValue() * num2Cnt;
            }
          }
        }
      }
    }
    return result1 + result2 / 2;
  }

}