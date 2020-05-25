package question0813_largest_sum_of_averages;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(K * A.length ^ 2)。
 *
 * 执行用时：7ms，击败91.12%。消耗内存：37.5MB，击败50.00%。
 */
public class Solution1 {
    private double[][] memo;

    public double largestSumOfAverages(int[] A, int K) {
        memo = new double[A.length + 1][K + 1];
        largestSumOfAverages(A, 0, K);
        return memo[0][K];
    }

    /**
     * 将数组 A 中 [start, A.length - 1] 范围内的元素分成 K 组，所能获得的平均值总和的最大值
     */
    private double largestSumOfAverages(int[] A, int start, int K) {
        if (start == A.length) {
            if (K == 0) {
                return 0.0;
            }
            return -1000000;
        }
        if (K <= 0) {
            return -1000000;
        }
        if (memo[start][K] != 0.0) {
            return memo[start][K];
        }
        // 尝试取一个分组 [start, i]
        double result = -1000000, tmp = 0;
        for (int i = start; i < A.length; i++) {
            tmp += A[i];
            result = Math.max(result, tmp / (i - start + 1) + largestSumOfAverages(A, i + 1, K - 1));
        }
        memo[start][K] = result;
        return result;
    }
}