package question1034_coloring_a_border;

public class Solution {

  private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private int m, n;

  private boolean[][] isEdge;

  public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
    m = grid.length;
    n = grid[0].length;
    dfs(grid, r0, c0);
    isEdge = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] < 0) {
          if (i == 0 || Math.abs(grid[i - 1][j]) != -grid[i][j]
              || i == m - 1 || Math.abs(grid[i + 1][j]) != -grid[i][j]
              || j == 0 || Math.abs(grid[i][j - 1]) != -grid[i][j]
              || j == n - 1 || Math.abs(grid[i][j + 1]) != -grid[i][j]) {
            isEdge[i][j] = true;
          }
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] < 0) {
          if (isEdge[i][j]) {
            grid[i][j] = color;
          } else {
            grid[i][j] = -grid[i][j];
          }
        }
      }
    }
    return grid;
  }

  private void dfs(int[][] grid, int r, int c) {
    grid[r][c] = -grid[r][c];
    for (int[] direction : directions) {
      int nextR = r + direction[0], nextC = c + direction[1];
      if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && grid[nextR][nextC] == -grid[r][c]) {
        dfs(grid, nextR, nextC);
      }
    }
  }

}