package question0045;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j]:从索引i到达索引j所需跳跃的最少步数
 *
 * 状态转移：
 * 如果nums[i] + i >= j，即dp[i][j] = 1。
 * 如果nums[i] + i < j，dp[i][j] = 1 + min{dp(i + 1, j), dp(i + 2, j), ... , dp(i + nums[i], j)}。
 *
 * 时间复杂度是O(n ^ 3)，其中n为nums数组的长度。空间复杂度是O(n ^ 2)。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution2 {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = n - 1;
                }
            }
        }
        for (int i = 0; i >= 1 - n; i--) {
            for (int j = 0; j < n + i; j++) {
                //待求的坐标是(j, j - i)
                if (nums[j] + j >= j - i) {
                    dp[j][j - i] = 1;
                } else {
                    for (int k = 1; k <= nums[j]; k++) {
                        dp[j][j - i] = Math.min(dp[j][j - i], 1 + dp[j + k][j - i]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
