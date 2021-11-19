package question1439_find_the_kth_smallest_sum_of_a_matrix_with_sorted_rows;

public class Solution {

  public int kthSmallest(int[][] mat, int k) {
    int m = mat.length, n = mat[0].length, left = 0, right = 0;
    for (int i = 0; i < m; i++) {
      left += mat[i][0];
      right += mat[i][n - 1];
    }
    int initial = left;
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      if (check(mat, mid, 0, initial, k) < k) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  /**
   * 在 [0, index - 1] 范围内，每行选取一个元素，得到的和为 curSum。接下来，在 [index, mat.length - 1] 范围内，
   * 每行选一个元素，最后得到的总和小于等于 sum 的选取方式共有多少种。
   */
  private static int check(int[][] mat, int sum, int index, int curSum, int k) {
    if (curSum > sum) {
      return 0;
    }
    if (index == mat.length) {
      return 1;
    }
    int result = check(mat, sum, index + 1, curSum, k);
    for (int i = 1; i < mat[0].length; i++) {
      if (curSum + mat[index][i] - mat[index][0] <= sum) {
        if (result >= k) {
          return result;
        }
        result += check(mat, sum, index + 1, curSum + mat[index][i] - mat[index][0], k);
      } else {
        break;
      }
    }
    return result;
  }

}