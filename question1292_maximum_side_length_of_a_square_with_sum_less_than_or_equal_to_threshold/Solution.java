package question1292_maximum_side_length_of_a_square_with_sum_less_than_or_equal_to_threshold;

public class Solution {

  public int maxSideLength(int[][] mat, int threshold) {
    int result = 0, m = mat.length, n = mat[0].length;
    int[][] sum = new int[m + 1][n + 1];
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result = Math.max(result, getMaxEdge(sum, i, j, 0, Math.min(m - i, n - j) - 1, threshold));
      }
    }
    return result;
  }

  private static int getMaxEdge(int[][] sum, int i, int j, int left, int right, int threshold) {
    while (left < right) {
      if (left + 1 == right) {
        if (check(sum, i, j, right, threshold)) {
          return right + 1;
        } else if (check(sum, i, j, left, threshold)) {
          return left + 1;
        }
        return 0;
      }
      int mid = left + ((right - left) >> 1);
      if (!check(sum, i, j, mid, threshold)) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    if (check(sum, i, j, right, threshold)) {
      return right + 1;
    }
    return 0;
  }

  private static boolean check(int[][] sum, int i, int j, int k, int threshold) {
    return sum[i + k + 1][j + k + 1] - sum[i][j + k + 1] - sum[i + k + 1][j] + sum[i][j] <= threshold;
  }

}