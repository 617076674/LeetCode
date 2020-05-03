package question0322_coin_change;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i]：组成和为i的最少硬币的数量。
 *
 * 初始化：
 * （1）当i != 0时，dp[i] = Integer.MAX_VALUE，表示暂时无法找到一种硬币组合使得其和为i。
 * （2）当i == 0时，dp[0] = 0。
 *
 * 状态转移：
 * dp[i] = Math.min(dp[i], 1 + dp[i - coin])，其中coin为coins数组中的硬币值，满足coin <= i。
 *
 * 时间复杂度是O(coins.length * amount)。空间复杂度是O(amount)。
 *
 * 执行用时：15ms，击败74.45%。消耗内存：39.4MB，击败5.77%。
 */
public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}