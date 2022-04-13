package question0798_smallest_rotation_with_highest_score;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

  public int bestRotation(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] -= i;
    }
    Map<Integer, Integer> map = new HashMap<>();
    int[] left = new int[nums.length + 1];
    for (int i = 1; i <= nums.length; i++) {
      left[i] = left[i - 1];
      left[i] -= map.getOrDefault(nums.length - i + 1, 0);
      if (nums.length - i >= nums[i - 1]) {
        left[i]++;
      }
      map.put(nums[i - 1], map.getOrDefault(nums[i - 1], 0) + 1);
    }
    map.clear();
    int[] right = new int[nums.length + 1];
    for (int i = nums.length - 1; i >= 0; i--) {
      right[i] = right[i + 1];
      right[i] += map.getOrDefault(-i, 0);
      if (nums[i] <= -i) {
        right[i]++;
      }
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    int result = -1, maxScore = 0;
    for (int k = 0; k < nums.length; k++) {
      int tempResult = left[k] + right[k];
      if (maxScore < tempResult) {
        maxScore = tempResult;
        result = k;
      }
    }
    return result;
  }

}