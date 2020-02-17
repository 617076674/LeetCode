package question1005_maximize_sum_of_array_after_k_negations;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/
 *
 * 时间复杂度是O(nlogn)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败78.97%。消耗内存43.2MB，击败5.37%。
 */
public class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int n;
        if (null == A || (n = A.length) == 0) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 0; i < n; i++) {
            if (A[i] < 0 && K > 0) {    //将负数翻成正数
                K--;
                A[i] = -A[i];
            } else if (A[i] == 0) { //如果存在数组A中0，那么只需尽可能多地将负数翻成正数即可，剩余的次数全部用于翻转0
                K = 0;
                break;
            }
        }
        if ((K & 1) == 0) {
            return sum(A);
        }
        //进入到这里，说明剩余的翻转次数K是一个奇数，此时，将最小的正数翻成负数即可
        Arrays.sort(A);
        A[0] = -A[0];
        return sum(A);
    }

    private int sum(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }
}