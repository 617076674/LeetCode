package question304;

/**
 * @author qianyihui
 * @date 2019-06-17
 *
 * 动态规划。
 *
 * 存储一个sum数组，其中sum[i][j]中存储[0, 0] - [i, j]范围内的区域和。（状态定义）
 *
 * sum数组的计算公式如下：（状态转移）
 *
 * （1）首先分别计算sum数组中第一行和第一列的值
 *
 * （2）sum[i][j] = matrix[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1]。
 *
 * 同理，对于sumRegion函数的计算也遵循上述原则。
 *
 * 时间复杂度和空间复杂度均是O(mn)，其中m为matrix数组的行数，n为matrix数组的列数。
 *
 * 执行用时：132ms，击败48.16%。消耗内存：46.5MB，击败87.50%。
 */
public class NumMatrix {

    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
        sum = new int[m][n];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            sum[0][i] = sum[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = matrix[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return sum[row2][col2];
        } else if (row1 == 0) {
            return sum[row2][col2] - sum[row2][col1 - 1];
        } else if (col1 == 0) {
            return sum[row2][col2] - sum[row1 - 1][col2];
        }
        return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
    }

}