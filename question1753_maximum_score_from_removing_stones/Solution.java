package question1753_maximum_score_from_removing_stones;

import java.util.Arrays;

public class Solution {

  public int maximumScore(int a, int b, int c) {
    int[] nums = {a, b, c};
    Arrays.sort(nums);
    if (nums[2] >= nums[0] + nums[1]) {
      return nums[0] + nums[1];
    }
    if (((nums[2] - nums[1] + nums[0]) & 1) == 0) {
      return nums[2] + nums[0] - (nums[2] - nums[1] + nums[0]) / 2;
    }
    return nums[2] + nums[0] - (nums[2] - nums[1] + nums[0]) / 2 - 1;
  }

}