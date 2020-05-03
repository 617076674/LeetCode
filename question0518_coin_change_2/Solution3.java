package question0518_coin_change_2;

/**
 * 状态定义：
 * dp[i][j]：用coins数组中[j, coins.length - 1]范围内的元素能组合成总金额i的组合数。
 *
 * 初始化：
 * （1）当i != 0时，dp[i][coins.length] = 0，因为区间[coins.length, coins.length - 1]内没有任何硬币。
 * （2）当i == 0时，dp[i][j] = 1，因为不需要任何硬币。
 *
 * 状态转移：
 * dp[i][j] = sum(dp[i - coins[j] * k][j + 1])，其中coins[j] * k <= i。
 *
 * 状态转移的优化
 * dp[i][j] = dp[i - coins[j] * 0][j + 1] + dp[i - coins[j] * 1][j + 1] + ... + dp[i - coins[j] * k][j + 1]，其中coins[j] * k <= i。
 *
 * dp[i - coins[j]][j] = dp[i - coins[j] * 1][j + 1]+ dp[i - coins[j] * 2][j + 1] + ... + dp[i - coins[j] * k][j + 1]，其中coins[j] * k <= i。
 *
 * 联立上述两个式子可得：
 *
 * dp[i][j] = dp[i][j + 1] + dp[i - coins[j]][j]
 *
 * 由于dp[i][j]的状态仅仅依赖于dp[i][j + 1]和dp[i - coins[j]][j]，因为可以进行状态压缩，用一维数组来保存状态。改进后的状态定义如下。
 *
 * 状态定义：
 * dp[i]：coins数组中的元素可以组合成总金额i的组合数。
 *
 * 初始化：
 * dp[0] = 1。
 *
 * 时间复杂度是O(coins.length * amount)。空间复杂度是O(amount)。
 *
 * 执行用时：3ms，击败73.73%。消耗内存：37.5MB，击败8.33%。
 */
public class Solution3 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i < dp.length; i++) {
                if (coin <= i) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}