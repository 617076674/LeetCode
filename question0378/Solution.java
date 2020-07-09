package question0378;

/**
 * 二分查找法。每次找小于等于 mid 的元素个数时，都利用矩阵的性质从矩阵的左下角开始找。
 *
 * 时间复杂度是 O((m + n) * log(max - min))，其中 m 为矩阵的行数，n 为矩阵的列数，max 为矩阵中的最大值，min 为矩阵中的最小值。
 * 空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败74.03%。消耗内存：45.7MB，击败7.69%。
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int count = 0, mid = left + (right - left) / 2, i = n - 1, j = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] <= mid) {
                    count += i + 1;
                    j++;
                } else {
                    i--;
                }
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}