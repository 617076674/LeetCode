package lcci1724_max_submatrix;

/**
 * 动态规划。
 *
 * 时间复杂度是 O(m * m * n)，其中 m 为矩阵 matrix 的行数，n 为矩阵 matrix 的列数。空间复杂度是 O(1)。
 *
 * 执行用时：58ms，击败68.93%。消耗内存：42.7MB，击败82.44%。
 */
public class Solution {
  public int[] getMaxMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[] result = new int[4];
    int maxSum = Integer.MIN_VALUE;
    int r1 = 0, r2 = 0;
    for (int i = 0; i < m; i++) {
      int[] tmp = new int[n];
      for (int j = i; j < m; j++) {
        int sum = 0;
        for (int k = 0; k < n; k++) {
          tmp[k] += matrix[j][k];
          if (sum > 0) {
            sum += tmp[k];
          } else {
            sum = tmp[k];
            r1 = i;
            r2 = k;
          }
          if (sum > maxSum) {
            maxSum = sum;
            result[0] = r1;
            result[1] = r2;
            result[2] = j;
            result[3] = k;
          }
        }
      }
    }
    return result;
  }
}