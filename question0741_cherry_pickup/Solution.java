package question0741_cherry_pickup;

import java.util.Arrays;

/**
 * 状态定义：
 * dp[i][j][k] 表示目前 A 在第 i 行， B 在第 j 行，已经走了 k 步，A 和 B 均到达 (N - 1, N - 1) 所能摘到的最大樱桃总数。
 *
 * 初始化条件：
 * dp[n - 1][n - 1][2 * n - 2] = grid[n - 1][n - 1]，其中 n 为 grid 矩阵的行数。
 *
 * 状态转移方程：
 * dp[i][j][k] = grid[i][k - i] + (i == j ? 0 : 1) * grid[j][k - j] + Math.max(dp[i + 1][j][k + 1], Math.max(dp[i][j + 1][k + 1], Math.max(dp[i + 1][j + 1][k + 1], dp[i][j][k + 1])))。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 3)。
 *
 * 执行用时：20ms，击败45.00%。消耗内存：40.8MB，击败50.00%。
 */
public class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n + 1][n + 1][2 * n - 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[n - 1][n - 1][2 * n - 2] = grid[n - 1][n - 1];
        for (int k = 2 * n - 3; k >= 0; k--) {
            // 已经走了 k 步
            for (int i = Math.min(k, n - 1); i >= Math.max(k - n + 1, 0); i--) {
                // 现在 A 所在的位置是 (i, k - i)
                for (int j = Math.min(k, n - 1); j >= Math.max(k - n + 1, 0); j--) {
                    // 现在 B 所在的位置是 (j, k - j)
                    if (grid[i][k - i] != -1 && grid[j][k - j] != -1) {
                            dp[i][j][k] = grid[i][k - i] + (i == j ? 0 : 1) * grid[j][k - j] + Math.max(dp[i + 1][j][k + 1],
                                    Math.max(dp[i][j + 1][k + 1], Math.max(dp[i + 1][j + 1][k + 1], dp[i][j][k + 1])));
                    }
                }
            }
        }
        return Math.max(0, dp[0][0][0]);
    }
}