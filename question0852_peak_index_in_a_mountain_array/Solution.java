package question0852_peak_index_in_a_mountain_array;

/**
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败62.93%。消耗内存：37.2MB，击败97.71%。
 */
public class Solution {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
