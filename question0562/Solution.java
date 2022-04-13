package question0562;

public class Solution {

  private int[][] mat;

  private Integer[][][] memo;

  private int m, n;

  private int[][] DIRECTIONS =
      {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

  public int longestLine(int[][] mat) {
    this.mat = mat;
    m = mat.length;
    n = mat[0].length;
    memo = new Integer[m][n][8];
    int result = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 0) {
          continue;
        }
        for (int dir = 0; dir < DIRECTIONS.length; dir++) {
          result =
              Math.max(result, longestLineHelper(i, j, dir++) + longestLineHelper(i, j, dir) - 1);
        }
      }
    }
    return result;
  }

  private int longestLineHelper(int x, int y, int dir) {
    if (x < 0 || x >= m || y < 0 || y >= n) {
      return 0;
    }
    if (mat[x][y] == 0) {
      return 0;
    }
    if (null != memo[x][y][dir]) {
      return memo[x][y][dir];
    }
    memo[x][y][dir] = 1 + longestLineHelper(x + DIRECTIONS[dir][0], y + DIRECTIONS[dir][1], dir);
    return memo[x][y][dir];
  }

}