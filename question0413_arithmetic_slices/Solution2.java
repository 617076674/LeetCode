package question0413_arithmetic_slices;

/**
 * 找规律。
 *
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37.1MB，击败5.38%。
 */
public class Solution2 {
    public int numberOfArithmeticSlices(int[] A) {
        int n, result = 0;
        if (null == A || (n = A.length) < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                count++;
            } else {
                result += count * (count + 1) / 2;
                count = 0;
            }
        }
        if (count != 0) {
            result += count * (count + 1) / 2;
        }
        return result;
    }
}