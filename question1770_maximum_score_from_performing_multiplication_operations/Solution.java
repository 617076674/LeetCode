package question1770_maximum_score_from_performing_multiplication_operations;

public class Solution {

  private Integer[][] memo;

  public int maximumScore(int[] nums, int[] multipliers) {
    memo = new Integer[multipliers.length][multipliers.length];
    return maximumScore(nums, 0, nums.length - 1, multipliers, 0);
  }

  private int maximumScore(int[] nums, int left, int right, int[] multipliers, int index) {
    if (index == multipliers.length) {
      return 0;
    }
    if (null != memo[left][index]) {
      return memo[left][index];
    }
    memo[left][index] = Math.max(nums[left] * multipliers[index] +
            maximumScore(nums, left + 1, right, multipliers, index + 1),
        nums[right] * multipliers[index] + maximumScore(nums, left, right - 1, multipliers,
            index + 1));
    return memo[left][index];
  }

}