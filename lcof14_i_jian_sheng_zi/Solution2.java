package lcof14_i_jian_sheng_zi;

/**
 * 动态规划。
 *
 * 时间复杂度和空间复杂度均是 O(n)。
 *
 * 执行用时：8ms，击败10.56%。消耗内存：36.3MB，击败100.00%。
 */
public class Solution2 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= 4; i++) {
            dp[i] = i;
        }
        for (int i = 5; i < n + 1; i++) {
            dp[i] = 3 * dp[i - 3];
        }
        return dp[n];
    }
}