package question1558_minimum_numbers_of_function_calls_to_make_target_array;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  private Map<Integer, int[]> memo = new HashMap<>();

  public int minOperations(int[] nums) {
    int result = 0, max = 0;
    for (int num : nums) {
        int[] times = getTimes(num);
        result += times[0];
        max = Math.max(times[1], max);
    }
    return result + max;
  }

  private int[] getTimes(int num) {
      if (num <= 1) {
          return new int[] {num, 0};
      }
      int[] result = memo.get(num);
      if (null != result) {
          return result;
      }
      if ((num & 1) == 1) {
          int[] temp = getTimes(num - 1);
          result = new int[] {temp[0] + 1, temp[1]};
      } else {
          int[] temp = getTimes(num / 2);
          result = new int[] {temp[0], temp[1] + 1};
      }
      memo.put(num, result);
      return result;
  }

}