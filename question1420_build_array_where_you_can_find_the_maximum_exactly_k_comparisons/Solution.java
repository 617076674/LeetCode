package question1420_build_array_where_you_can_find_the_maximum_exactly_k_comparisons;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j][k] 表示长度为 i，其中的最大值为 j，搜索代价为 k 的数组数目。
 *
 * 初始化条件：
 * dp[i][1][1] = 1。
 * dp[1][j][1] = 1。
 *
 * 状态转移方程：
 * dp[i][j][k] =
 * dp[i - 1][j][k] * j  （这种情况表示最大值 j 出现在 [0, i - 1] 范围内，那么第 i 位可以取 [1, j]）
 * + sum(dp[i - 1][p][k - 1]), p ∈ [1, j - 1]  （这种情况表示最大值 j 出现在第 i 位，那么 [0, i - 1] 范围内的最大值可以是 [1, j - 1]）
 *
 * 时间复杂度是 O(n * k * m ^ 2)。空间复杂度均是 O(n * k * m)。
 *
 * 执行用时：33ms，击败62.10%。消耗内存：39.8MB，击败45.24%。
 */
public class Solution {
    public int numOfArrays(int n, int m, int k) {
        if (k == 0 || m < k) {
            return 0;
        }
        int mod = 1000000007;
        long[][][] dp = new long[n + 1][m + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1][1] = 1;
        }
        for (int i = 0; i <= m; i++) {
            dp[1][i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                for (int l = 1; l <= k; l++) {
                    dp[i][j][l] = dp[i - 1][j][l] * j;
                    for (int p = 1; p <= j - 1; p++) {
                        dp[i][j][l] += dp[i - 1][p][l - 1];
                    }
                    dp[i][j][l] %= mod;
                }
            }
        }
        long result = 0;
        for (int i = 1; i <= m; i++) {
            result += dp[n][i][k];
            result %= mod;
        }
        return (int) result;
    }
}