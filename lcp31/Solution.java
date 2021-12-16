package lcp31;

import java.util.List;

public class Solution {

  private List<List<String>> maze;

  private int m;

  private int n;

  private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {0, 0}};

  private Boolean[][][][][] memo1;

  private Boolean[][][][][] memo2;

  public boolean escapeMaze(List<List<String>> maze) {
    this.maze = maze;
    this.m = maze.get(0).size();
    this.n = maze.get(0).get(0).length();
    memo1 = new Boolean[m][n][maze.size()][2][2];
    memo2 = new Boolean[m][n][maze.size()][2][2];
    return escapeMazeHelper(0, 0, 1, 1, 1);
  }

  private boolean escapeMazeHelperHelper(int x, int y, int mazeIndex, int magic1, int magic2) {
    if (mazeIndex == maze.size()) {
      return x == m - 1 && y == n - 1;
    }
    if (memo2[x][y][mazeIndex][magic1][magic2] != null) {
      return memo2[x][y][mazeIndex][magic1][magic2];
    }
    if (escapeMazeHelper(x, y, mazeIndex, magic1, magic2)) {
      memo2[x][y][mazeIndex][magic1][magic2] = true;
      return true;
    }
    memo2[x][y][mazeIndex][magic1][magic2] = escapeMazeHelperHelper(x, y, mazeIndex + 1, magic1, magic2);
    return memo2[x][y][mazeIndex][magic1][magic2];
  }

  private boolean escapeMazeHelper(int x, int y, int mazeIndex, int magic1, int magic2) {
    if (mazeIndex == maze.size()) {
      return x == m - 1 && y == n - 1;
    }
    if (memo1[x][y][mazeIndex][magic1][magic2] != null) {
      return memo1[x][y][mazeIndex][magic1][magic2];
    }
    boolean result = false;
    for (int[] direction : DIRECTIONS) {
      int nextX = x + direction[0], nextY = y + direction[1];
      if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
        if (maze.get(mazeIndex).get(nextX).charAt(nextY) == '.') {
          result = escapeMazeHelper(nextX, nextY, mazeIndex + 1, magic1, magic2);
        } else {
          if (magic1 == 1) {
            result = escapeMazeHelper(nextX, nextY, mazeIndex + 1, 0, magic2);
          }
          if (!result && magic2 == 1) {
            result = escapeMazeHelperHelper(nextX, nextY, mazeIndex + 1, magic1, 0);
          }
        }
        if (result) {
          memo1[x][y][mazeIndex][magic1][magic2] = true;
          return true;
        }
      }
    }
    memo1[x][y][mazeIndex][magic1][magic2] = false;
    return false;
  }

}