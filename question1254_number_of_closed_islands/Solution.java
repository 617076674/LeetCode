package question1254_number_of_closed_islands;

public class Solution {

  private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private int m, n;

  public int closedIsland(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
    for (int j = 0; j < n; j++) {
      if (grid[0][j] == 0) {
        dfs(grid, 0, j);
      }
    }
    for (int j = 0; j < n; j++) {
      if (grid[m - 1][j] == 0) {
        dfs(grid, m - 1, j);
      }
    }
    for (int i = 0; i < m; i++) {
      if (grid[i][0] == 0) {
        dfs(grid, i, 0);
      }
    }
    for (int i = 0; i < m; i++) {
      if (grid[i][n - 1] == 0) {
        dfs(grid, i, n - 1);
      }
    }
    int result = 0;
    for (int i = 1; i < m - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        if (grid[i][j] == 0) {
          result++;
          dfs(grid, i, j);
        }
      }
    }
    return result;
  }

  private void dfs(int[][] grid, int row, int col) {
    grid[row][col] = 1;
    for (int[] direction : directions) {
      int nextRow = row + direction[0], nextCol = col + direction[1];
      if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 0) {
        grid[nextRow][nextCol] = 1;
        dfs(grid, nextRow, nextCol);
      }
    }
  }

  public static void main(String[] args) {
    int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
    System.out.println(new Solution().closedIsland(grid));
  }

}