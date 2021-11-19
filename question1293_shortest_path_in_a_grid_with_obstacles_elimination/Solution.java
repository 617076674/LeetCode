package question1293_shortest_path_in_a_grid_with_obstacles_elimination;

public class Solution {

  private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  private int m, n;

  private Integer[][][] memo;

  private boolean[][][] visited;

  public int shortestPath(int[][] grid, int k) {
    m = grid.length;
    n = grid[0].length;
    memo = new Integer[m][n][m * n + 1];
    visited = new boolean[m][n][m * n + 1];
    int result = shortestPathHelper(grid, 0, 0, k);
    return result >= Integer.MAX_VALUE / 2 ? -1 : result;
  }

  private int shortestPathHelper(int[][] grid, int x, int y, int k) {
    if (x == m - 1 && y == n - 1) {
      return 0;
    }
    if (null != memo[x][y][k]) {
      return memo[x][y][k];
    }
    visited[x][y][k] = true;
    int result = Integer.MAX_VALUE / 2;
    for (int[] direction : directions) {
      int nextX = x + direction[0], nextY = y + direction[1];
      if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
        int nextK = grid[nextX][nextY] == 1 ? k - 1 : k;
        if (nextK >= 0 && !visited[nextX][nextY][nextK]) {
          result = Math.min(result, 1 + shortestPathHelper(grid, nextX, nextY, nextK));
        }
      }
    }
    memo[x][y][k] = result;
    visited[x][y][k] = false;
    return result;
  }

}