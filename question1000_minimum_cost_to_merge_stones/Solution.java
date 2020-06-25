package question1000_minimum_cost_to_merge_stones;

import java.util.Arrays;

/**
 * 状态定义：
 * dp[i][j][k] 表示将 stones 数组中 [i, j] 范围内的石头合并为 k 堆所需的代价。
 *
 * 初始化条件：
 * dp[i][i][1] = 0。
 *
 * 状态转移方程：
 * dp[i][j][k] = min(dp[i][m][1] + dp[m + 1][j][k - 1]), m ∈ [i, j), k ∈ [2, K]。
 * dp[i][j][1] = dp[i][j][K] + A[i] + ... + A[j]。
 *
 * 时间复杂度是 O(K * n ^ 3)，其中 n 为数组 stones 的长度。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：5ms，击败65.52%。消耗内存：39.4MB，击败100.00%。
 */
public class Solution {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) {
            return -1;
        }
        int[] sum = new int[n + 1]; // sum[i] = stones[0] + ... + stones[i - 1]
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + stones[i - 1];
        }
        int[][][] dp = new int[n][n][K + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i][1] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 2; k <= K; k++) {
                    for (int m = i; m < j; m += K - 1) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][m][1] + dp[m + 1][j][k - 1]);
                    }
                }
                dp[i][j][1] = dp[i][j][K] + sum[j + 1] - sum[i];
            }
        }
        return dp[0][n - 1][1];
    }
}