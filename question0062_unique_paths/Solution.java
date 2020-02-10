package question0062_unique_paths;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j]：到达坐标(i, j)的路径数
 *
 * 状态转移：
 * （1）当i == 0或j == 0时，dp[i][j] = 1。
 *
 * （2）dp[i][j] = dp[i - 1][j] + dp[i][j - 1]。
 *
 * 时间复杂度和空间复杂度均是O(mn)。
 *
 * 执行用时：1ms，击败67.12%。消耗内存：33.1MB，击败30.39%。
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}