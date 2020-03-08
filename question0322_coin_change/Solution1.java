package question0322_coin_change;

import java.util.HashMap;
import java.util.Map;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是O(coins.length * amount)。空间复杂度是O(amount)。
 *
 * 执行用时：205ms，击败5.05%。消耗内存：42.7MB，击败5.01%。
 */
public class Solution1 {
    private Map<Integer, Long> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        long result = dfs(coins, amount);
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return (int) result;
    }

    private long dfs(int[] coins, int amount) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount == 0) {
            memo.put(0, 0L);
            return 0;
        }
        long result = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                result = Math.min(result, 1 + dfs(coins, amount - coin));
            }
        }
        memo.put(amount, result);
        return result;
    }
}