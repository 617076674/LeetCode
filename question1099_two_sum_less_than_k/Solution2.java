package question1099_two_sum_less_than_k;

import java.util.Arrays;

/**
 * 双指针。
 *
 * 时间复杂度是O(nlogn)，其中n是数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：36.4MB，击败100.00%。
 */
public class Solution2 {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int result = -1, left = 0, right = A.length - 1;
        while (left < right) {
            int sum = A[left] + A[right];
            if (sum >= K) {
                right--;
            } else {
                result = Math.max(result, sum);
                left++;
            }
        }
        return result;
    }
}