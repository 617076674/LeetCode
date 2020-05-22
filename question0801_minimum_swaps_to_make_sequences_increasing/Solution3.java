package question0801_minimum_swaps_to_make_sequences_increasing;

/**
 * 状态压缩。
 *
 * 时间复杂度是 O(n)，其中 n 为数组 A 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：2ms，击败95.47%。消耗内存：40.1MB，击败100.00%。
 */
public class Solution3 {
    public int minSwap(int[] A, int[] B) {
        int num0 = 0, num1 = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int newNum0 = Integer.MAX_VALUE, newNum1 = Integer.MAX_VALUE;
            if (i == 0) {
                newNum0 = newNum1 = Math.min(newNum0, Math.min(num0, num1 + 1));
            } else {
                if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                    newNum0 = Math.min(newNum0, num0);
                    newNum1 = Math.min(newNum1, num1 + 1);
                }
                if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                    newNum0 = Math.min(newNum0, num1 + 1);
                    newNum1 = Math.min(newNum1, num0);
                }
            }
            num0 = newNum0;
            num1 = newNum1;
        }
        return num0;
    }
}