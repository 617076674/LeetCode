package question0801_minimum_swaps_to_make_sequences_increasing;

/**
 * 状态定义：
 * dp[i][0] 表示未交换 A[i - 1] 和 B[i - 1]，
 * 数组 A 中 [i, A.length - 1] 范围内的元素和数组 B 中 [i, B.length - 1] 范围内的元素均保持严格递增所需的最小交换次数。
 *
 * dp[i][1] 表示交换了 A[i - 1] 和 B[i - 1]，
 * 数组 A 中 [i, A.length - 1] 范围内的元素和数组 B 中 [i, B.length - 1] 范围内的元素均保持严格递增所需的最小交换次数。
 *
 * 初始化条件：
 * dp[A.length][0] = dp[A.length][1] = 0。
 *
 * 状态转移方程：
 * 当 i == 0时，dp[i][0] = dp[i][1] = min(dp[i + 1][0], dp[i + 1][1])。
 * 若有 A[i] > A[i - 1] && B[i] > B[i - 1]，dp[i][0] = min(dp[i][0], dp[i + 1][0]), dp[i][1] = min(dp[i][1], dp[i + 1][0])。
 * 若有 A[i] > B[i - 1] && B[i] > A[i - 1]，dp[i][0] = min(dp[i][0], dp[i + 1][1] + 1), dp[i][1] = min(dp[i][1], dp[i + 1][1] + 1)。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为数组 A 的长度。
 *
 * 执行用时：5ms，击败11.15%。消耗内存：39.8MB，击败100.00%。
 */
public class Solution2 {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = dp[i][1] = Integer.MAX_VALUE;
            if (i == 0) {
                dp[i][0] = dp[i][1] = Math.min(dp[i][0], Math.min(dp[i + 1][0], dp[i + 1][1] + 1));
            } else {
                if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                    dp[i][0] = Math.min(dp[i][0], dp[i + 1][0]);
                    dp[i][1] = Math.min(dp[i][1], dp[i + 1][1] + 1);
                }
                if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                    dp[i][0] = Math.min(dp[i][0], dp[i + 1][1] + 1);
                    dp[i][1] = Math.min(dp[i][1], dp[i + 1][0]);
                }
            }
        }
        return dp[0][0];
    }
}