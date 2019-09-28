package question0766_toeplitz_matrix;

/**
 * 时间复杂度是O(m * n)，其中m为矩阵的行数，n为矩阵的列数。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败93.07%。消耗内存：39.4MB，击败98.25%。
 */
public class Solution {
    private int m;

    private int n;

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (null == matrix || (m = matrix.length) == 0) {
            return true;
        }
        if (null == matrix[0] || (n = matrix[0].length) == 0) {
            return true;
        }
        for (int i = 0; i < m; i++) {
            if (!isSameDiagonal(matrix, i, 0)) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!isSameDiagonal(matrix, 0, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSameDiagonal(int[][] matrix, int i, int j) {
        while (i + 1 < m && j + 1 < n) {
            if (matrix[i + 1][j + 1] != matrix[i][j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
