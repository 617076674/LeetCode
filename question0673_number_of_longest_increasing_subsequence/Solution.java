package question0673_number_of_longest_increasing_subsequence;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][0]表示以 nums[i] 结尾的最长递增子序列的长度。
 * dp[i][1]表示以 nums[i] 结尾的最长递增子序列的个数。
 *
 * 初始化条件：
 * dp[0][0] = dp[0][1] = 1。
 *
 * 状态转移方程：
 * dp[i][0] = max(dp[j][0] + 1), j ∈ [0, i) 且 nums[i] > nums[j]。
 *
 * 当 dp[j][0] + 1 == dp[i][0] 时，dp[i][1] += dp[j][1]。
 * 当 dp[j][0] + 1 > dp[i][0] 时，dp[i][1] = dp[j][1]。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为 nums 数组的长度。空间复杂度是 O(n)。
 *
 * 执行用时：20ms，击败59.43%。消耗内存：39.5MB，击败11.11%。
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n;
        if ((n = nums.length) <= 1) {
            return n;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        int maxLen = 1, result = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j][0] + 1 == dp[i][0]) {
                        dp[i][1] += dp[j][1];
                    } else if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    }
                }
            }
            if (dp[i][0] == maxLen) {
                result += dp[i][1];
            } else if (dp[i][0] > maxLen) {
                maxLen = dp[i][0];
                result = dp[i][1];
            }
        }
        return result;
    }
}