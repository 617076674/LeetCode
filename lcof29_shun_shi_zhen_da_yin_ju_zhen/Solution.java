package lcof29_shun_shi_zhen_da_yin_ju_zhen;

/**
 * 时间复杂度是 O(m * n)，其中 m 为 matrix 数组的行数，n 为 matrix 数组的列数。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败97.18%。消耗内存：41.1MB，击败100.00%
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int m;
        if (null == matrix || (m = matrix.length) == 0) {
            return new int[0];
        }
        int n;
        if (null == matrix[0] || (n = matrix[0].length) == 0) {
            return new int[0];
        }
        int[] result = new int[m * n];
        int index = 0, left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[index++] = matrix[bottom][i];
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[index++] = matrix[i][left];
                }
                left++;
            }
        }
        return result;
    }
}