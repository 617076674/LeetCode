package question0518_coin_change_2;

/**
 * 时间复杂度和空间复杂度均是O(coins.length * amount)。
 *
 * 执行用时：13ms，击败13.14%。消耗内存：44MB，击败8.33%。
 */
public class Solution2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        dp[0][coins.length] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                dp[i][j] = dp[i][j + 1];
                if (coins[j] <= i) {
                    dp[i][j] += dp[i - coins[j]][j];
                }
            }
        }
        return dp[amount][0];
    }
}
