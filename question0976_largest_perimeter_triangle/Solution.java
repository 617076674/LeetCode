package question0976_largest_perimeter_triangle;

import java.util.Arrays;

/**
 * 排序后依次取最长的3条边，直至取到3条能组成三角形的边为止。
 *
 * 时间复杂度是O(nlogn)，其中n是数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：12ms，击败95.70%。消耗内存：38.5MB，击败95.54%。
 */
public class Solution {
    public int largestPerimeter(int[] A) {
        int n;
        if (null == A || (n = A.length) < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = n - 1; i >= 2; i--) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}
