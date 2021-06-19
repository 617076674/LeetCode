package question0494_target_sum;

public class Solution {

  private Integer[][] memo;

  public int findTargetSumWays(int[] nums, int target) {
    memo = new Integer[nums.length][2001];
    return findTargetSumWaysHelper(nums, nums.length - 1, target);
  }

  private int findTargetSumWaysHelper(int[] nums, int index, int target) {
    if (target > 1000 || target < -1000) {
      return 0;
    }
    if (index == 0) {
      if (target == nums[0] && target == -nums[0]) {
        return 2;
      }
      if (target == nums[0] || target == -nums[0]) {
        return 1;
      }
      return 0;
    }
    if (memo[index][target + 1000] != null) {
      return memo[index][target + 1000];
    }
    memo[index][target + 1000] =
        findTargetSumWaysHelper(nums, index - 1, target + nums[index]) + findTargetSumWaysHelper(nums, index - 1, target - nums[index]);
    return memo[index][target + 1000];
  }

}