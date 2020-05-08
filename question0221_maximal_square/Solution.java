package question0221_maximal_square;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j]表示以matrix[i][j]为右下角的最大正方形边长。
 *
 * 初始化条件：
 * （1）当i == 0时，dp[0][j] = matrix[0][j] - '0'
 * （2）当j == 0时，dp[i][0] = matrix[i][0] - '0'
 *
 * 状态转移方程：
 * （1）当matrix[i][j] == '1`时，dp[i][j] = min(dp[i - 1][j - 1], max1, max2)，
 * 其中 max1 为第 j 列中从 i - 1 行往前的连续的 1 的个数， max2 为第 i 行中从 j - 1 列往前的连续的 1 的个数。
 * （2）当matrix[i][j] == '0'时，dp[i][j] = 0。
 *
 * 时间复杂度和空间复杂度均是O(m * n)，其中m为矩阵matrix的行数，n为矩阵matrix的列数。
 *
 * 执行用时：5ms，击败94.15%。消耗内存：42.7MB，击败62.50%。
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m;
        if (null == matrix || (m = matrix.length) == 0) {
            return 0;
        }
        int n;
        if (null == matrix[0] || (n = matrix[0].length) == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                result = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                result = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int max1 = 0, max2 = 0;
                    for (int k = i - 1; k >= 0 && matrix[k][j] == '1'; k--) {
                        max1++;
                    }
                    for (int k = j - 1; k >= 0 && matrix[i][k] == '1'; k--) {
                        max2++;
                    }
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(max1, max2)) + 1;
                    result = Math.max(result, dp[i][j] * dp[i][j]);
                }
            }
        }
        return result;
    }
}