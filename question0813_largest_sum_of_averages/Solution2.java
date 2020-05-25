package question0813_largest_sum_of_averages;

/**
 * 动态规划。
 *
 * 状态定义：
 * dp[i][j] 表示将数组 A 中 [i, A.length - 1] 范围内的元素分成 j 个非空子数组，所能得到的最大分数值。
 *
 * 初始化条件：
 * dp[A.length][0] = 0.0。
 * dp[A.length][j] = dp[i][0] = -1000000，用一个很小的数表示不可能有这种分割。
 *
 * 状态转移方程：
 * dp[i][j] = max(dp[k + 1][j - 1] + tmp / (k - i + 1))，其中 k∈[i, A.length - 1]，tmp表示 [i, k] 范围内的元素和。
 *
 * 时间复杂度和空间复杂度均是 O(K * A.length ^ 2)。
 *
 * 执行用时：13ms，击败40.65%。消耗内存：37.2MB，击败50.00%。
 */
public class Solution2 {
    public double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[A.length + 1][K + 1];
        for (int i = 1; i < K + 1; i++) {
            dp[A.length][i] = -1000000;
        }
        for (int i = 0; i < A.length; i++) {
            dp[i][0] = -1000000;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = -1000000;
                double tmp = 0.0;
                for (int k = i; k < A.length; k++) {
                    tmp += A[k];
                    dp[i][j] = Math.max(dp[i][j], tmp / (k - i + 1) + dp[k + 1][j - 1]);
                }
            }
        }
        return dp[0][K];
    }
}