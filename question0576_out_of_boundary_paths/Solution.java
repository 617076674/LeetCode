package question0576_out_of_boundary_paths;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j][k]：从坐标(i, j)出发第k步出界的路径总数。
 *
 * 状态转移：
 * dp[i][j][k] = dp[i - 1][j][k - 1] + dp[i + 1][j][k - 1] + dp[i][j - 1][k - 1] + dp[i][j + 1][k - 1]。
 *
 * 时间复杂度和空间复杂度均是O(m * n * N)。
 *
 * 执行用时：11ms，击败58.96%。消耗内存：40.9MB，击败6.25%。
 */
public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        long[][][] dp = new long[m + 2][n + 2][N + 1];
        for (int k = 0; k < n + 2; k++) {
            dp[0][k][0] = 1;
            dp[m + 1][k][0] = 1;
        }
        for (int k = 0; k < m + 2; k++) {
            dp[k][0][0] = 1;
            dp[k][n + 1][0] = 1;
        }
        for (int k = 1; k <= N; k++) {
            for (int l = 1; l <= m; l++) {
                for (int o = 1; o <= n; o++) {
                    dp[l][o][k] = (dp[l - 1][o][k - 1] + dp[l + 1][o][k - 1] + dp[l][o + 1][k - 1] + dp[l][o - 1][k - 1]) % 1000000007;
                }
            }
        }
        long result = 0;
        for (int k = 1; k <= N; k++) {
            result = result + dp[i + 1][j + 1][k];
        }
        return (int) (result % 1000000007);
    }
}