package question0375_guess_number_higher_or_lower_ii;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j]：从[i, j]范围内猜一个数的最大代价
 *
 * 状态转移：
 * dp[i][j] = min(i + dp[i + 1][j], j + dp[i][j - 1], k + max(dp[i][k - 1], dp[k + 1][j])), k∈(i, j)
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)。
 *
 * 执行用时：9ms，击败42.82。消耗内存：36.9MB，击败6.36%。
 */
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1]; //从[i, j]内猜一个数的最大代价是dp[i][j]
        for (int gap = -1; gap >= -n; gap--) {
            for (int i = 1; i <= n + gap ; i++) {
                int j = i - gap, tmp = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    if (k == i) {
                        tmp = Math.min(tmp, k + dp[i + 1][j]);
                    } else if (k == j) {
                        tmp = Math.min(tmp, k + dp[i][j - 1]);
                    } else {
                        tmp = Math.min(tmp, k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                    }
                }
                dp[i][j] = tmp;
            }
        }
        return dp[1][n];
    }
}