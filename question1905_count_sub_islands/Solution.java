package question1905_count_sub_islands;

public class Solution {

  private boolean[][] visited;

  private int m, n;

  private static class Flag {
    boolean value = true;
  }

  public int countSubIslands(int[][] grid1, int[][] grid2) {
    m = grid1.length;
    n = grid1[0].length;
    visited = new boolean[m][n];
    int result = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && grid2[i][j] == 1) {
          Flag flag = new Flag();
          dfs(grid1, grid2, i, j, flag);
          if (flag.value) {
            result++;
          }
        }
      }
    }
    return result;
  }

  private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  private void dfs(int[][] grid1, int[][] grid2, int x, int y, Flag flag) {
    visited[x][y] = true;
    if (flag.value && grid1[x][y] == 0) {
      flag.value = false;
    }
    for (int[] direction : directions) {
      int nextX = direction[0] + x, nextY = direction[1] + y;
      if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid2[nextX][nextY] == 1
          && !visited[nextX][nextY]) {
        dfs(grid1, grid2, nextX, nextY, flag);
      }
    }
  }

}