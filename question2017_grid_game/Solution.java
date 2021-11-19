package question2017_grid_game;

public class Solution {

  public long gridGame(int[][] grid) {
    int n = grid[0].length;
    long[][] sums = new long[2][n + 1];
    for (int i = 1; i < n + 1; i++) {
      sums[0][i] = sums[0][i - 1] + grid[0][i - 1];
      sums[1][i] = sums[1][i - 1] + grid[1][i - 1];
    }
    long result = Long.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      // 第一个人在 i 列向下走
      long choice ;
      if (i == 0) {
        choice = sums[0][n] - sums[0][i + 1];
      } else if (i == n - 1) {
        choice = sums[1][i];
      } else {
        choice = Math.max(sums[0][n] - sums[0][i + 1], sums[1][i]);
      }
      result = Math.min(choice, result);
    }
    return result;
  }

}