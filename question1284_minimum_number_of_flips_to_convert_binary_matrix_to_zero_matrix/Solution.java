package question1284_minimum_number_of_flips_to_convert_binary_matrix_to_zero_matrix;

public class Solution {

  private int m, n;

  private Integer[] memo;

  private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  private boolean[] visited;

  public int minFlips(int[][] mat) {
    m = mat.length;
    n = mat[0].length;
    memo = new Integer[1 << (m * n)];
    visited = new boolean[1 << (m * n)];
    int status = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 1) {
          status ^= (1 << getIndex(i, j));
        }
      }
    }
    int result = minFlipsHelper(status);
    return result >= Integer.MAX_VALUE / 2 ? -1 : result;
  }

  private int minFlipsHelper(int status) {
    if (status == 0) {
      return 0;
    }
    if (memo[status] != null) {
      return memo[status];
    }
    visited[status] = true;
    int result = Integer.MAX_VALUE / 2;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int nextStatus = status;
        // 翻转 mat[i][j]
        nextStatus ^= (1 << getIndex(i, j));
        for (int[] direction : directions) {
          int nextI = i + direction[0], nextJ = j + direction[1];
          if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
            nextStatus ^= (1 << getIndex(nextI, nextJ));
          }
        }
        if (!visited[nextStatus]) {
          result = Math.min(result, 1 + minFlipsHelper(nextStatus));
        }
      }
    }
    memo[status] = result;
    visited[status] = false;
    return result;
  }

  private int getIndex(int i, int j) {
    return i * n + j;
  }

}