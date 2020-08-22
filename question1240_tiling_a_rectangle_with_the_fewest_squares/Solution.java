package question1240_tiling_a_rectangle_with_the_fewest_squares;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示大小为 i * j 的客厅最少需要的方形瓷砖数量。
 *
 * 初始化条件：
 * dp[i][i] = 1。
 *
 * 状态转移方程：
 * https://leetcode-cn.com/problems/tiling-a-rectangle-with-the-fewest-squares/solution/1240-pu-ci-zhuan-dong-tai-gui-hua-by-acw_weian/
 *
 * 时间复杂度是 O(m * n * (min(m, n) ^ 2))。空间复杂度是 O(m * n)。
 *
 * 执行用时：3ms，击败80.67%。消耗内存：36.5MB，击败60.87%。
 */
public class Solution {
    public int tilingRectangle(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = m * n;
                    for (int k = 1; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[k][j] + dp[i - k][j]);
                    }
                    for (int k = 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[i][j - k]);
                    }
                    for (int p = 1; p <= Math.min(i, j); p++) {
                        for (int k = 1; k <= p; k++) {
                            if (p - k > 0 && j - p > 0 && i - p + k > 0 && j - p - k > 0) {
                                dp[i][j] = Math.min(dp[i][j], dp[p - k][j - p] + dp[i - p + k][j - p - k] + dp[i - p][p + k] + 2);
                            }
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }
}