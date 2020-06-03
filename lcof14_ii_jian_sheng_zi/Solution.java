package lcof14_ii_jian_sheng_zi;

/**
 * 动态规划。
 *
 * 当 n >= 5 时，3 * (n - 3) >= 2 * (n - 2)。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.3MB，击败100.00%。
 */
public class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= 4; i++) {
            dp[i] = i;
        }
        for (int i = 5; i < n + 1; i++) {
            dp[i] = (int) ((3 * (long) dp[i - 3]) % 1000000007);
        }
        return dp[n];
    }
}