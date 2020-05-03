package question0518_coin_change_2;

/**
 * 时间复杂度是O(coins.length * amount ^ 2)。空间复杂度是O(coins.length * amount)。
 *
 * 执行用时：121ms，击败5.04%。消耗内存：43.9MB，击败8.33%。
 */
public class Solution1 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        dp[0][coins.length] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                for (int k = 0; k * coins[j] <= i; k++) {
                    dp[i][j] += dp[i - coins[j] * k][j + 1];
                }
            }
        }
        return dp[amount][0];
    }
}