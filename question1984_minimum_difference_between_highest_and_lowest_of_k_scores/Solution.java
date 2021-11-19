package question1984_minimum_difference_between_highest_and_lowest_of_k_scores;

import java.util.Arrays;

public class Solution {

  public int minimumDifference(int[] nums, int k) {
    Arrays.sort(nums);
    int result = Integer.MAX_VALUE;
    for (int i = 0; i + k - 1 < nums.length; i++) {
      // [i, i + k - 1]
      result = Math.min(result, nums[i + k - 1] - nums[i]);
    }
    return result;
  }

}