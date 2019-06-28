package question0378;

/**
 * @author qianyihui
 * @date 2019-06-28
 *
 * 二分查找法。每次找小于等于mid的元素个数时，都利用矩阵的性质从矩阵的左下角开始找。
 *
 * 时间复杂度是O((m + n) * log(max - min))，其中m为矩阵的行数，n为矩阵的列数，max为矩阵中的最大值，min为矩阵中的最小值。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败97.09%。消耗内存：50MB，击败36.59%。
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int left = matrix[0][0], right = matrix[m - 1][n - 1];
        while (left <= right) {
            int count = 0, mid = left + (right - left) / 2;
            int i = m - 1, j = 0;
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
                right = mid - 1;
            }
        }
        return left;
    }
}
