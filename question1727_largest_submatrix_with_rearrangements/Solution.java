package question1727_largest_submatrix_with_rearrangements;

import java.util.Arrays;

public class Solution {

  public int largestSubmatrix(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1) {
          matrix[i][j] += matrix[i - 1][j];
        }
      }
    }
    int result = 0;
    for (int[] line : matrix) {
      Arrays.sort(line);
      for (int j = n - 1; j >= 0; j--) {
        result = Math.max(result, line[j] * (n - j));
      }
    }
    return result;
  }

}