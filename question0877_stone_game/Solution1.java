package question0877_stone_game;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是O(n ^ 2)，其中n为piles数组的长度。
 *
 * 执行用时：18ms，击败33.40%。消耗内存：40.8MB，击败23.26%。
 */
public class Solution1 {
    private int[][] dp;

    private int[] sum;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        sum = new int[n];
        sum[0] = piles[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + piles[i];
        }
        int score = stoneGame(piles, 0, n - 1);
        return score > sum[n - 1] - score;
    }

    /**
     * 对于piles数组中[left, right]范围内的元素，先取的人能获得的最大石头数是多少
     */
    private int stoneGame(int[] piles, int left, int right) {
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        if (left == right) {
            return piles[left];
        }
        dp[left + 1][right] = stoneGame(piles, left + 1, right);
        dp[left][right - 1] = stoneGame(piles, left, right - 1);
        int total = sum[right];
        if (left != 0) {
            total -= sum[left - 1];
        }
        return Math.max(total - dp[left + 1][right], total - dp[left][right - 1]);
    }
}