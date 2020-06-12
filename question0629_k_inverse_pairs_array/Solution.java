package question0629_k_inverse_pairs_array;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示数字 [1, i] 中包含 j 对逆序对的个数。
 *
 * 初始化条件：
 * dp[0][0] = 1。
 * 当 j != 0 时，dp[0][j] = 0。
 * 当 i != 0 时，dp[i][0] = 1。
 *
 * 状态转移方程：
 * dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1] + ... + dp[i - 1][j - i + 1]。
 * dp[i][j - 1] = dp[i - 1][j - 1] + dp[i - 1][j - 2] + ... + dp[i - 1][j - i]。
 *
 * 可以推出 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - i]。
 *
 * 时间复杂度和空间复杂度均是 O(n * k)。
 *
 * 执行用时：24ms，击败69.17%。消耗内存：40MB，击败33.33%。
 */
public class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int MOD = 1000000007;
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                if (j - i >= 0) {
                    dp[i][j] -= dp[i - 1][j - i];
                    if (dp[i][j] < 0) {
                        dp[i][j] += MOD;
                    }
                }
                dp[i][j] %= MOD;
            }
        }
        return dp[n][k];
    }
}