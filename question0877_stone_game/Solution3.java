package question0877_stone_game;

/**
 * 对Solution2进行状态压缩。
 *
 * 时间复杂度是O(n ^ 2)，其中n为piles数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：6ms，击败54.83%。消耗内存：37.5MB，击败8.33%。
 */
public class Solution3 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];
        int[] sum = new int[n];
        sum[0] = piles[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + piles[i];
        }
        for (int i = 0; i < n; i++) {
            dp[i] = piles[i];
        }
        for (int gap = -1; gap >= 1 - n; gap--) {
            for (int i = 0; i < n + gap; i++) {
                int j = i - gap, total = sum[j];
                if (i > 0) {
                    total -= sum[i - 1];
                }
                dp[i] = Math.max(total - dp[i + 1], total - dp[i]);
            }
        }
        return dp[0] > sum[n - 1] - dp[0];
    }
}