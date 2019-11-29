package question1099_two_sum_less_than_k;

/**
 * 暴力破解法。
 *
 * 时间复杂度是O(n ^ 2)，其中n是数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败46.76%。消耗内存：35.6MB，击败100.00%。
 */
public class Solution1 {
    public int twoSumLessThanK(int[] A, int K) {
        int result = -1, n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A[i] + A[j];
                if (sum < K && sum > result) {
                    result = sum;
                }
            }
        }
        return result;
    }
}