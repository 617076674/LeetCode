package question0801_minimum_swaps_to_make_sequences_increasing;

/**
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为数组 A 的长度。
 *
 * 执行用时：3ms，击败48.78%。消耗内存：39.9MB，击败100.00%
 */
public class Solution1 {
    private int[][] memo;

    public int minSwap(int[] A, int[] B) {
        memo = new int[A.length][2];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < 2; j++) {
                memo[i][j] = -1;
            }
        }
        return minSwap(A, B, 0, 0);
    }

    /**
     * 使数组 A 中 [index, A.length - 1] 范围内的元素和数组 B 中 [index, B.length - 1] 范围内的元素均保持严格递增所需的最小交换次数。
     * pre == 1 表示上一步有交换
     * pre == 0 表示上一步没有交换
     */
    private int minSwap(int[] A, int[] B, int index, int pre) {
        if (index == A.length) {
            return 0;
        }
        if (memo[index][pre] != -1) {
            return memo[index][pre];
        }
        int result = Integer.MAX_VALUE;
        if (pre == 0) {
            // 不交换 A[index] 和 B[index]
            if (index == 0 || (A[index] > A[index - 1] && B[index] > B[index - 1])) {
                result = Math.min(result, minSwap(A, B, index + 1, 0));
            }
            // 交换 A[index] 和 B[index]
            if (index == 0 || (A[index] > B[index - 1] && B[index] > A[index - 1])) {
                result = Math.min(result, 1 + minSwap(A, B, index + 1, 1));
            }
        } else {
            if (index == 0 || (A[index] > B[index - 1] && B[index] > A[index - 1])) {
                result = Math.min(result, minSwap(A, B, index + 1, 0));
            }
            // 交换 A[index] 和 B[index]
            if (index == 0 || (A[index] > A[index - 1] && B[index] > B[index - 1])) {
                result = Math.min(result, 1 + minSwap(A, B, index + 1, 1));
            }
        }
        memo[index][pre] = result;
        return result;
    }
}