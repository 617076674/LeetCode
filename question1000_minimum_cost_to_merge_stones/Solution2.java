package question1000_minimum_cost_to_merge_stones;

import java.util.Arrays;

/**
 * 状态定义：
 * dp[i][j] 合并数组 stones 中 [i, j] 范围内的元素（合并结果不一定是一堆）的最低成本。
 *
 * 初始化条件：
 * 当 i == j 时，dp[i][j] = 0。
 *
 * 状态转移方程：
 * dp[i][j] = min(dp[i][m] + dp[m - 1][j]), m ∈ [i, j] 且 m = i + Z * (K - 1)。
 * 如果 [i, j] 范围内的元素还能合并，即 (j - i) % (K - 1) == 0，则有 dp[i][j] += stones[i] + ... + stones[j]。
 *
 * 时间复杂度是 O((n ^ 3) / K)。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：4ms，击败72.65%。消耗内存：37.2MB，击败100.00%。
 */
public class Solution2 {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) {
            return -1;
        }
        int[] sum = new int[n + 1]; // sum[i] = stones[0] + ... + stones[i - 1]
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + stones[i - 1];
        }
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int m = i; m < j; m += K - 1) {
                    dp[i][j] = Math.min(dp[i][m] + dp[m + 1][j], dp[i][j]);
                }
                if ((j - i) % (K - 1) == 0) {
                    dp[i][j] += sum[j + 1] - sum[i];
                }
            }
        }
        return (int) dp[0][n - 1];
    }
}