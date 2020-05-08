package question0877_stone_game;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j]表示对piles数组[i, j]内的元素，先取的人能得到的最大石子数。
 *
 * 初始化条件：
 * 当 i == j 时，dp[i][j] = piles[i]
 *
 * 状态转移：
 * dp[i][j] = max(total - dp[i + 1][j], total - dp[i][j - 1])，
 * 其中，当i == 0时，total = sum[j]；当i > 0时，total = sum[j] - sum[i - 1]
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为piles数组的长度。
 *
 * 执行用时：9ms，击败44.86%。消耗内存：40.4MB，击败8.33%。
 */
public class Solution2 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        int[] sum = new int[n];
        sum[0] = piles[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + piles[i];
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int gap = -1; gap >= 1 - n; gap--) {
            for (int i = 0; i < n + gap; i++) {
                int j = i - gap, total = sum[j];
                if (i > 0) {
                    total -= sum[i - 1];
                }
                dp[i][j] = Math.max(total - dp[i + 1][j], total - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > sum[n - 1] - dp[0][n - 1];
    }
}