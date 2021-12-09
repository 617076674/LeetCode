package question2025;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int waysToPartition(int[] nums, int k) {
    // sumsLeft[i] = nums[0] + ... + nums[i - 1]
    // sumsRight[i] = nums[i] + ... + nums[n - 1]
    long[] sumsLeft = new long[nums.length + 1], sumsRight = new long[nums.length + 1];
    for (int i = 1; i < sumsLeft.length; i++) {
      sumsLeft[i] = sumsLeft[i - 1] + nums[i - 1];
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      sumsRight[i] = sumsRight[i + 1] + nums[i];
    }
    int result = 0;  // 不改变任何数
    for (int i = 1; i < nums.length; i++) {
      if (sumsRight[i] == sumsLeft[i]) {
        result++;
      }
    }
    Map<Long, Integer> rightMap = new HashMap<>();
    for (int i = 1; i < nums.length; i++) {
      // [0, i - 1], [i, n - 1]
      long temp = sumsRight[i] - sumsLeft[i];
      rightMap.put(temp, rightMap.getOrDefault(temp, 0) + 1);
    }
    Map<Long, Integer> leftMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      // 将 nums[i] 变成 k
      long gap = k - nums[i];
      result = Math.max(result, leftMap.getOrDefault(-gap, 0) + rightMap.getOrDefault(gap, 0));
      if (i == nums.length - 1) {
        return result;
      }
      long temp = sumsRight[i + 1] - sumsLeft[i + 1];
      rightMap.put(temp, rightMap.get(temp) - 1);
      leftMap.put(temp, leftMap.getOrDefault(temp, 0) + 1);
    }
    return result;
  }

}