package question0343_integer_break;

/**
 * 动态规划。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.8MB，击败7.69%。
 */
public class Solution2 {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= 4; i++) {
            dp[i] = i;
        }
        for (int i = 5; i < n + 1; i++) {
            dp[i] = Math.max(2 * dp[i - 2], 3 * dp[i - 3]);
        }
        return dp[n];
    }
}