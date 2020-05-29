package question1140_stone_game_ii;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示从第 i 堆石头开始拿起，M 为 j，先手能拿到的最大分数。
 *
 * 初始化条件：
 * dp[n][j] = 0，其中 n 为 piles 数组的长度。
 *
 * 状态转移方程：
 * 当 n - i <= 2 * k 时，
 *     当 i + k < n 时，dp[i][j] = max(sum[i] - sum[i + k]), k ∈ [1, 2 * j]。
 *     当 i + k >= n 时，dp[i][j] = sum[i]。
 * 当 n - i > 2 * k 时，
 *     dp[i][j] = max(sum[i] - dp[i + k][max(j, k)]), k ∈ [1, 2 * j]。
 *
 * 时间复杂度和空间复杂度均是 O(n ^ 3)，其中 n 为数组 piles 的长度。
 *
 * 执行用时：6ms，击败33.18%。消耗内存：37.3MB，击败100.00%。
 */
public class Solution2 {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] sum = new int[n];
        sum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        int[][] dp = new int[n][n / 2 + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                dp[i][j] = 0;
                for (int k = 1; k <= 2 * j; k++) {
                    if (n - i > 2 * k) {
                        dp[i][j] = Math.max(dp[i][j], sum[i] - dp[i + k][Math.max(j, k)]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], i + k < n ? sum[i] - sum[i + k] : sum[i]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}