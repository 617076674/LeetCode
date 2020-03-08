package question0322_coin_change;

import java.util.Arrays;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i]：组成和为i的最少硬币的数量，当无法组成和为i时dp[i] = Integer.MAX_VALUE
 *
 * 状态转移：
 * dp[i] = Math.min(dp[i], 1 + dp[i - coin])，其中coin为coins数组中的硬币值，满足coin <= i。
 *
 * 时间复杂度是O(coins.length * amount)。空间复杂度是O(amount)。
 *
 * 执行用时：18ms，击败38.55%。消耗内存：41.2MB，击败5.01%。
 */
public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0L;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }
}