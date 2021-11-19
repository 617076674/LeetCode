package question1975_maximum_matrix_sum;

public class Solution {

  public long maxMatrixSum(int[][] matrix) {
    long result = 0;
    int m = matrix.length, n = matrix[0].length;
    int minAbs = Integer.MIN_VALUE;
    int countNonPositive = 0;
    boolean hasZero = false;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result += Math.abs(matrix[i][j]);
        if (matrix[i][j] < 0) {
          countNonPositive++;

        }
        minAbs = Math.min(minAbs, Math.abs(matrix[i][j]));
        if (matrix[i][j] == 0) {
          hasZero = true;
        }
      }
    }
    if ((countNonPositive & 1) == 0 || hasZero) {
      return result;
    }
    return result + minAbs * 2;
  }

}