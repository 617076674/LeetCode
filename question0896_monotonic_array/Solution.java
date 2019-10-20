package question0896_monotonic_array;

/**
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败87.21%。消耗内存：49MB，击败94.19%。
 */
public class Solution {
    public boolean isMonotonic(int[] A) {
        boolean riseFlag = true, downFlag = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                downFlag = false;
            }
            if (A[i] > A[i + 1]) {
                riseFlag = false;
            }
        }
        return riseFlag || downFlag;
    }
}
