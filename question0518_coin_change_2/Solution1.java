package question0518_coin_change_2;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j]：coins中[0, i - 1]范围内的硬币能够凑成总金额j的组合数。
 *
 * 状态转移：
 * dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]], j >= coins[i - 1]
 *
 * dp[i][j] = dp[i - 1][j], j < coins[i - 1]
 *
 * 时间复杂度和空间复杂度均是O(amount * coins.length)。
 *
 * 执行用时：9ms，击败20.57%。消耗内存：45.2MB，击败6.20%。
 */
public class Solution1 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}