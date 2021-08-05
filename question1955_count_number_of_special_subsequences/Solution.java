package question1955_count_number_of_special_subsequences;

/**
 * dp[i] 以 nums[i] 结尾的特殊子序列的前缀的数目，该特殊子序列不需要以 2 结尾。
 */
public class Solution {

  private static int MOD = 1000000007;

  public int countSpecialSubsequences(int[] nums) {
    int[] dp = new int[nums.length];
    int[] sums = new int[3];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        dp[i]++;
        dp[i] %= MOD;
      }
      dp[i] += sums[nums[i]];
      dp[i] %= MOD;
      if (nums[i] > 0) {
        dp[i] += sums[nums[i] - 1];
        dp[i] %= MOD;
      }
      sums[nums[i]] += dp[i];
      sums[nums[i]] %= MOD;
    }
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 2) {
        result += dp[i];
        result %= MOD;
      }
    }
    return result;
  }

}