package lcof47_li_wu_de_zui_da_jie_zhi;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示走到棋盘 grid[i][j] 处能获得的最大礼物总和。
 *
 * 初始化条件：
 * dp[0][0] = grid[0][0]。
 * 当 i != 0 时，dp[i][0] = dp[i - 1][0] + grid[i][0]。
 * 当 j != 0 时，dp[0][j] = dp[0][j - 1] + grid[0][j]。
 *
 * 状态转移方程：
 * dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]。
 *
 * 时间复杂度和空间复杂度均是 O(m * n)，其中 m 为矩阵 grid 的行数，n 为矩阵 grid 的列数。
 *
 * 执行用时：3ms，击败83.37%。消耗内存：42.6MB，击败100.00%。
 */
public class Solution {
    public int maxValue(int[][] grid) {
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
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}