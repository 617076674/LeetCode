package question_zero_matrix_lcci;

/**
 * 用第1行标记对应的列是否需要清空，用第1列标记对应的行是否需要清空。
 *
 * 时间复杂度是O(m * n)，其中m为矩阵matrix的行数，n为矩阵matrix的列数。空间复杂度是O(1)。
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m;
        if (null == matrix || (m = matrix.length) == 0) {
            return;
        }
        int n;
        if (null == matrix[0] || (n = matrix[0].length) == 0) {
            return;
        }
        boolean clearFirstRow = false, clearFirstCol = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        clearFirstRow = true;
                    }
                    if (j == 0) {
                        clearFirstCol = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (clearFirstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (clearFirstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}