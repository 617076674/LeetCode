package question0063_unique_paths_ii;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * 动态规划。
 *
 * 时间复杂度和空间复杂度均是O(mn)，其中m是obstacleGrid的行数，n是obstacleGrid的列数。
 *
 * 执行用时：1ms，击败89.29%。消耗内存：40MB，击败7.10%。
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m;
        if (null == obstacleGrid || (m = obstacleGrid.length) == 0) {
            return 0;
        }
        int n;
        if (null == obstacleGrid[0] || (n = obstacleGrid[0].length) == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}