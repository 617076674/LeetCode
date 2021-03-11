package question1605_find_valid_matrix_given_row_and_column_sums;

public class Solution {

  public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
    int m = rowSum.length, n = colSum.length;
    int[][] result = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result[i][j] = Math.min(rowSum[i], colSum[j]);
        rowSum[i] -= result[i][j];
        colSum[j] -= result[i][j];
      }
    }
    return result;
  }

}