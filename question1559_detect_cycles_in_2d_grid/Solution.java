package question1559_detect_cycles_in_2d_grid;

public class Solution {

  private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  private int m, n;

  public boolean containsCycle(char[][] grid) {
    m = grid.length;
    n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (check(grid, i, j, -1, -1, 1, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean check(char[][] grid, int curX, int curY, int preX, int preY, int len,
                        boolean[][] visited) {
    if (visited[curX][curY]) {
      return len >= 4;
    }
    visited[curX][curY] = true;
    for (int[] direction : directions) {
      int nextX = direction[0] + curX, nextY = direction[1] + curY;
      if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && (nextX != preX || nextY != preY)
          && grid[nextX][nextY] == grid[curX][curY]
          && check(grid, nextX, nextY, curX, curY, len + 1, visited)) {
          return true;
      }
    }
    return false;
  }

}