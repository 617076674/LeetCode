package question2009_minimum_number_of_operations_to_make_array_continuous;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int minOperations(int[] nums) {
    Arrays.sort(nums);
    Map<Integer, Integer> window = new HashMap<>();
    int left = 0, right = 0, result = nums.length;
    while (right < nums.length) {
      while (right < nums.length && nums[right] - nums[left] <= nums.length - 1) {
        if (!window.containsKey(nums[right])) {
          window.put(nums[right], 1);
        } else {
          window.put(nums[right], window.get(nums[right]) + 1);
        }
        right++;
      }
      result = Math.min(result, nums.length - window.size());
      if (window.get(nums[left]) == 1) {
        window.remove(nums[left]);
      } else {
        window.put(nums[left], window.get(nums[left]) - 1);
      }
      left++;
    }
    return result;
  }

}