package question0977;

/**
 * @author qianyihui
 * @date 2019-08-21
 *
 * 双指针。
 *
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：7ms，击败62.51%。消耗内存：51.9MB，击败48.00%。
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length, min = n - 1;
        for (int i = 1; i < n; i++) {
            if (Math.abs(A[i]) > Math.abs(A[i - 1])) {
                min = i - 1;
                break;
            }
        }
        int[] result = new int[n];
        int index = 0, index1 = min - 1, index2 = min + 1;
        result[index++] = A[min] * A[min];
        while (true) {
            if (index1 < 0 && index2 >= n) {
                break;
            }
            if (index1 < 0) {
                result[index++] = A[index2] * A[index2];
                index2++;
            } else if (index2 >= n) {
                result[index++] = A[index1] * A[index1];
                index1--;
            } else if (Math.abs(A[index1]) <= Math.abs(A[index2])) {
                result[index++] = A[index1] * A[index1];
                index1--;
            } else {
                result[index++] = A[index2] * A[index2];
                index2++;
            }
        }
        return result;
    }
}