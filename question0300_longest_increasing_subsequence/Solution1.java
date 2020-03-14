package question0300_longest_increasing_subsequence;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i]，以索引i处数字结尾的最长上升子序列的长度。
 *
 * 状态转移：
 * dp[0] = 1
 * 当i > 0时，dp[i] = Math.max(dp[j] + 1, dp[i])，其中j∈[0, i)且nums[i] > nums[j]
 *
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：22ms，击败65.26%。消耗内存：36.6MB，击败31.51%。
 */
public class Solution1 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        int result = dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
}