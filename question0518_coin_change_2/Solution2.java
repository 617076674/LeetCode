package question0518_coin_change_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 对Solution进行降维处理。
 *
 * 时间复杂度是O(amount * coins.length)。空间复杂度是O(amount)。
 *
 * 执行用时：4ms，击败44.80%。消耗内存：37.4MB，击败6.20%。
 */
public class Solution2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}