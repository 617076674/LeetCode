package question0064_minimum_path_sum;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示从左上角 (0, 0) 位置到达 (i, j) 路径位置上数字总和的最小值。
 *
 * 初始化条件：
 * dp[0][0] = grid[0][0]。
 *
 * 状态转移方程：
 * dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]。
 *
 * 时间复杂度和空间复杂度均是O(mn)，其中m是obstacleGrid的行数，n是obstacleGrid的列数。
 *
 * 执行用时：3ms，击败83.69%。消耗内存：41.5MB，击败30.78%。
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m;
        if (null == grid || (m = grid.length) == 0) {
            return 0;
        }
        int n;
        if (null == grid[0] || (n = grid[0].length) == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}