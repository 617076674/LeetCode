package question1031_maximum_sum_of_two_non_overlapping_subarrays;

public class Solution {

    private int[] sums;

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        sums = new int[A.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + A[i - 1];
        }
        return Math.max(getMaxSum(A, L, M), getMaxSum(A, M, L));
    }

    private int getMaxSum(int[] A, int L, int M) {
        int result = Integer.MIN_VALUE;
        // 在 [0, i] 中寻找 L, 在 [i + 1, A.length - 1] 中寻找 M
        // i + 1 >= L 推出 i >= L - 1
        // A.length - 1 - i >= M 推出 i <= A.length - 1 - M
        for (int i = L - 1; i <= A.length - 1 - M; i++) {
            // [0, i] 中寻找 L
            int max1 = Integer.MIN_VALUE;
            for (int j = L - 1; j <= i; j++) {
                max1 = Math.max(max1, sums[j + 1] - sums[j + 1 - L]);
            }
            int max2 = Integer.MIN_VALUE;
            for (int j = i + M; j <= A.length - 1; j++) {
                max2 = Math.max(max2, sums[j + 1] - sums[j + 1 - M]);
            }
            result = Math.max(result, max1 + max2);
        }
        return result;
    }

}