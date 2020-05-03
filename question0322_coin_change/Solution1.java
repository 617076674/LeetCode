package question0322_coin_change;

import java.util.Arrays;

/**
 * 时间复杂度是O(coins.length * amount)。空间复杂度是O(amount)。
 *
 * 执行用时：30ms，击败20.38%。消耗内存：39.6MB，击败5.77%。
 */
public class Solution1 {
    private int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        dfs(coins, amount);
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }

    private int dfs(int[] coins, int amount) {
        if (memo[amount] != -1) {
            return memo[amount];
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int tmp = dfs(coins, amount - coin);
                if (tmp != Integer.MAX_VALUE) {
                    result = Math.min(result, 1 + tmp);
                }
            }
        }
        memo[amount] = result;
        return result;
    }
}