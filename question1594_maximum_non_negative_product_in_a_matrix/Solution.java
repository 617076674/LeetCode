package question1594_maximum_non_negative_product_in_a_matrix;

/**
 * 动态规划。
 *
 * 时间复杂度和空间复杂度均是 O(m * n)，其中 m 为 grid 矩阵的行数，n 为 grid 矩阵的列数。
 *
 * 执行用时：2ms，击败96.24%。消耗内存：38.7MB，击败21.89%。
 */
public class Solution {

    private static final int MOD = 1000000007;

    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m][n][2];
        dp[0][0][0] = dp[0][0][1] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i][0][1] = dp[i - 1][0][0] * grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j][0] = dp[0][j][1] = dp[0][j - 1][0] * grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long max = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
                long min = Math.min(dp[i - 1][j][1], dp[i][j - 1][1]);
                if (grid[i][j] >= 0) {
                    dp[i][j][0] = max * grid[i][j];
                    dp[i][j][1] = min * grid[i][j];
                } else {
                    dp[i][j][0] = min * grid[i][j];
                    dp[i][j][1] = max * grid[i][j];
                }
            }
        }
        return (int) Math.max(dp[m - 1][n - 1][0] % MOD, -1);
    }

}