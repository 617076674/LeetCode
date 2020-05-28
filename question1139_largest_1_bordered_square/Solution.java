package question1139_largest_1_bordered_square;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j][0] 表示坐标 grid[i][j] 向上延伸的连续的 1 的个数。
 * dp[i][j][1] 表示坐标 grid[i][j] 向右延伸的连续的 1 的个数。
 * dp[i][j][2] 表示坐标 grid[i][j] 向下延伸的连续的 1 的个数。
 * dp[i][j][3] 表示坐标 grid[i][j] 向左延伸的连续的 1 的个数。
 *
 * 初始化条件：
 * 当 grid[0][j] == 1 时，dp[0][j][0] = 1；当 grid[0][j] == 0 时，dp[0][j][0] = 0。
 * 当 grid[m - 1][j] == 1 时，dp[m - 1][j][2] = 1；当 grid[m - 1][j] == 0 时，dp[m - 1][j][2] = 0。
 * 当 grid[i][0] == 1 时，dp[i][0][3] = 1；当 grid[i][0] == 0 时，dp[i][0][3] = 0。
 * 当 grid[i][n - 1] == 1 时，dp[i][n - 1][1] = 1；当 grid[i][n - 1] == 0 时，dp[i][n - 1][1] = 0。
 *
 * 状态转移方程：
 * dp[i][j][0] = dp[i - 1][j][0] + 1。
 * dp[i][j][1] = dp[i][j + 1][1] + 1。
 * dp[i][j][2] = dp[i + 1][j][2] + 1。
 * dp[i][j][3] = dp[i][j - 1][3] + 1。
 *
 * 时间复杂度是 O(m * n * min(m, n))。空间复杂度是 O(m * n)。
 *
 * 执行用时：9ms，击败59.36%。消耗内存：40.7MB，击败100.00%。
 */
public class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length, result = 0;
        int[][][] dp = new int[m][n][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 向上走
                    dp[i][j][0] = i == 0 ? 1 : dp[i - 1][j][0] + 1;
                    // 向左走
                    dp[i][j][3] = j == 0 ? 1 : dp[i][j - 1][3] + 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    // 向右走
                    dp[i][j][1] = j == n - 1 ? 1 : dp[i][j + 1][1] + 1;
                    // 向下走
                    dp[i][j][2] = i == m - 1 ? 1 : dp[i + 1][j][2] + 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int len = Math.min(dp[i][j][1], dp[i][j][2]); len >= 1; len--) {
                        if (Math.min(dp[i + len - 1][j + len - 1][0], dp[i + len - 1][j + len - 1][3]) >= len) {
                            result = Math.max(result, len * len);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}