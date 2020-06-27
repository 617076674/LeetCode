package question0312_burst_balloons;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示刺穿 nums 数组中 [i, j] 范围内的气球，所能得到的最大分数。
 *
 * 初始化条件：
 * 当 i > j 时，dp[i][j] = 0。
 *
 * 状态转移方程：
 * dp[i][j] = max(dp[i][k - 1] + dp[k + 1][j] + nums[k] * nums[i - 1] * nums[j + 1]。
 *
 * 时间复杂度是 O(n ^ 3)，其中 n 为数组 nums 的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：12ms，击败22.24%。消耗内存：37.6MB，击败25.00%。
 */
public class Solution2 {
    public int maxCoins(int[] nums) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    int leftNum = i - 1 >= 0 ? nums[i - 1] : 1, rightNum = j + 1 < n ? nums[j + 1] : 1,
                            leftResult = k - 1 >= 0 ? dp[i][k - 1] : 0, rightResult = k + 1 < n ? dp[k + 1][j] : 0;
                    dp[i][j] = Math.max(dp[i][j], nums[k] * leftNum * rightNum + leftResult + rightResult);
                }
            }
        }
        return dp[0][n - 1];
    }
}