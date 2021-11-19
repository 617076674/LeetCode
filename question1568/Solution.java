package question1568;

public class Solution {

  private int m, n;

  public static void main(String[] args) {
    int[][] grid = {{0,1,1,0},{0,1,1,0},{0,0,0,0}};
    System.out.println(new Solution().minDays(grid));
  }

  public int minDays(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
    if (check(grid)) {
      return 0;
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          grid[i][j] = 0;
          if (check(grid)) {
            return 1;
          }
          grid[i][j] = 1;
        }
      }
    }
    return 2;
  }

  private boolean check(int[][] grid) {
    int blocks = 0;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          blocks++;
          visited[i][j] = true;
          dfs(i, j, visited, grid);
        }
      }
    }
    return blocks != 1;
  }

  private static final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  private void dfs(int x, int y, boolean[][] visited, int[][] grid) {
    for (int[] direction : directions) {
      int nextX = direction[0] + x, nextY = direction[1] + y;
      if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
        visited[nextX][nextY] = true;
        dfs(nextX, nextY, visited, grid);
      }
    }
  }

}