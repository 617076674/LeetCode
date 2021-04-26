package question0377_combination_sum_iv;

public class Solution {

  private Integer[] memo;

  public int combinationSum4(int[] nums, int target) {
    memo = new Integer[target + 1];
    return combinationSum4Helper(nums, target);
  }

  private int combinationSum4Helper(int[] nums, int target) {
    if (target == 0) {
      return 1;
    }
    if (null != memo[target]) {
      return memo[target];
    }
    memo[target] = 0;
    for (int num : nums) {
      if (num <= target) {
        memo[target] += combinationSum4Helper(nums, target - num);
      }
    }
    return memo[target];
  }

}