package question0977_squares_of_a_sorted_array;

/**
 * 双指针。
 *
 * 时间复杂度是O(n)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：7ms，击败62.51%。消耗内存：51.9MB，击败48.00%。
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length, min = n - 1;  //可能存在[-3, -2, -1, 0]这样的数组，没有绝对值的上升沿，需要将min初始化为n - 1
        for (int i = 1; i < n; i++) {
            if (Math.abs(A[i]) > Math.abs(A[i - 1])) {
                min = i - 1;
                break;
            }
        }
        int[] result = new int[n];
        int index = 0, index1 = min - 1, index2 = min + 1;
        result[index++] = A[min] * A[min];
        while (index1 >= 0 || index2 < n) {
            if (index1 < 0 || (index2 < n && Math.abs(A[index1]) > Math.abs(A[index2]))) {
                result[index++] = A[index2] * A[index2];
                index2++;
            } else {
                result[index++] = A[index1] * A[index1];
                index1--;
            }
        }
        return result;
    }
}