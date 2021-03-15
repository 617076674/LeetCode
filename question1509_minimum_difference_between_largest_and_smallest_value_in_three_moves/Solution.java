package question1509_minimum_difference_between_largest_and_smallest_value_in_three_moves;

import java.util.Arrays;

public class Solution {

  public int minDifference(int[] nums) {
    int n = nums.length;
    if (n <= 3) {
      return 0;
    }
    Arrays.sort(nums);
    return Math.min(nums[n - 1] - nums[3], Math.min(nums[n - 2] - nums[2],
        Math.min(nums[n - 3] - nums[1], nums[n - 4] - nums[0])));
  }

}