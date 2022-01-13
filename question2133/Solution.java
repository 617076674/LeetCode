package question2133;

public class Solution {

  public boolean checkValid(int[][] matrix) {
    // 每行
    for (int i = 0; i < matrix.length; i++) {
      boolean[] visited = new boolean[matrix.length + 1];
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[i][j] < 1 || matrix[i][j] > matrix.length) {
          return false;
        }
        visited[matrix[i][j]] = true;
      }
      for (int j = 1; j <= matrix.length; j++) {
        if (!visited[j]) {
          return false;
        }
      }
    }
    // 每列
    for (int j = 0; j < matrix.length; j++) {
      boolean[] visited = new boolean[matrix.length + 1];
      for (int i = 0; i < matrix.length; i++) {
        if (matrix[i][j] < 1 || matrix[i][j] > matrix.length) {
          return false;
        }
        visited[matrix[i][j]] = true;
      }
      for (int i = 1; i <= matrix.length; i++) {
        if (!visited[i]) {
          return false;
        }
      }
    }
    return true;
  }

}