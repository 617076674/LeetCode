package question1064_fixed_point;

/**
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：40.3MB，击败6.06%。
 */
public class Solution {
    public int fixedPoint(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i == A[i]) {
                return i;
            }
        }
        return -1;
    }
}