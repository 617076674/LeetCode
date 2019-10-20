package question0908_smallest_range_i;

/**
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败89.69%。消耗内存：38.6MB，击败93.66%。
 */
public class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : A) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return Math.max(0, max - min - (K << 1));
    }
}
