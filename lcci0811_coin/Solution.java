package lcci0811_coin;

/**
 * 执行用时：44ms，击败39.25%。消耗内存：43.7MB，击败100.00%。
 */
public class Solution {
    public int waysToChange(int n) {
        int[] coins = {25, 10, 5, 1}, dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] += dp[j - coins[i]];
                dp[j] %= 1000000007;
            }
        }
        return dp[n];
    }
}