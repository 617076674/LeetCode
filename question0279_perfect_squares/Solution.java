package question0279_perfect_squares;

/**
 * 动态规划。
 *
 * 时间复杂度是O(nlogn)。空间复杂度是O(n)。
 *
 * 执行用时：39ms，击败75.96%。消耗内存：39.3MB，击败10.53%。
 */
public class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = n;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}