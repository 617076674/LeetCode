package question1074_number_of_submatrices_that_sum_to_target;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O((m * n) ^ 2)，其中 m 是矩阵 matrix 的行数，n 是矩阵 matrix 的列数。空间复杂度是 O(m * n)。
 *
 * 执行用时：7669ms，击败14.20%。消耗内存：45.1MB，击败66.67%。
 */
public class Solution1 {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length, result = 0;
    int[][] sum = new int[m][n];  // sum[i][j] 表示 (i, j) 左上角的矩阵元素总和
    sum[0][0] = matrix[0][0];
    for (int j = 1; j < n; j++) {
      sum[0][j] = sum[0][j - 1] + matrix[0][j];
    }
    for (int i = 1; i < m; i++) {
      sum[i][0] = sum[i - 1][0] + matrix[i][0];
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
      }
    }
    for (int x1 = 0; x1 < m; x1++) {
      for (int x2 = x1; x2 < m; x2++) {
        for (int y1 = 0; y1 < n; y1++) {
          for (int y2 = y1; y2 < n; y2++) {
            if (x1 != 0 && y1 != 0) {
              if (sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1] == target) {
                result++;
              }
            } else if (x1 == 0 && y1 == 0) {
              if (sum[x2][y2] == target) {
                result++;
              }
            } else if (x1 == 0) {
              if (sum[x2][y2] - sum[x2][y1 - 1] == target) {
                result++;
              }
            } else {
              if (sum[x2][y2] - sum[x1 - 1][y2] == target) {
                result++;
              }
            }
          }
        }
      }
    }
    return result;
  }
}