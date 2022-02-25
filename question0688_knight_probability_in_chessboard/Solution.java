package question0688_knight_probability_in_chessboard;

public class Solution {

  private int n;

  private Double[][][] memo;

  private static final int[][] DIRECTIONS = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1},
      {-2, -1}, {-1, -2}};

  public double knightProbability(int n, int k, int row, int column) {
    this.n = n;
    memo = new Double[k + 1][n][n];
    return knightProbabilityHelper(k, row, column);
  }

  private double knightProbabilityHelper(int k, int row, int column) {
    if (row < 0 || row >= n || column < 0 || column >= n) {
      return 0.0;
    }
    if (k == 0) {
      return 1.0;
    }
    if (null != memo[k][row][column]) {
      return memo[k][row][column];
    }
    double result = 0.0;
    for (int[] direction : DIRECTIONS) {
      int nextRow = row + direction[0];
      int nextColumn = column + direction[1];
      result += knightProbabilityHelper(k - 1, nextRow, nextColumn) / 8.0;
    }
    memo[k][row][column] = result;
    return result;
  }

}