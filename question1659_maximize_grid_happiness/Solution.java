package question1659_maximize_grid_happiness;

public class Solution {

  private int m;

  private int n;

  private int[][][] deltaScore = {{{0, 120, 40}, {0, 60, 30}, {0, 110, 80}},
      {{0, 60, 30}, {0, 0, 20}, {0, 50, 70}}, {{0, 110, 80}, {0, 50, 70}, {0, 100, 120}}};

  private int[][][][][] memo;

  public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
    this.m = m;
    this.n = n;
    memo = new int[m][n][introvertsCount + 1][extrovertsCount + 1][(int) Math.pow(3, n)];
    return getMaxGridHappiness(0, 0, introvertsCount, extrovertsCount, 0);
  }

  private int getMaxGridHappiness(int x, int y, int introvertsCount, int extrovertsCount, int status) {
    if (introvertsCount + extrovertsCount == 0 || x == m) {
      return 0;
    }
    if (memo[x][y][introvertsCount][extrovertsCount][status] != 0) {
      return memo[x][y][introvertsCount][extrovertsCount][status];
    }
    int up = x == 0 ? 0 : (int) ((status / Math.pow(3, n - 1)) % 3);
    int left = y == 0 ? 0 : status % 3;
    int[] next = nextPosition(x, y);
    int result = getMaxGridHappiness(next[0], next[1], introvertsCount, extrovertsCount, shiftAndSet(status, 0));
    if (introvertsCount > 0) {
      result = Math.max(result, deltaScore[up][left][1] + getMaxGridHappiness(next[0], next[1], introvertsCount - 1, extrovertsCount, shiftAndSet(status, 1)));
    }
    if (extrovertsCount > 0) {
      result = Math.max(result, deltaScore[up][left][2] + getMaxGridHappiness(next[0], next[1], introvertsCount, extrovertsCount - 1, shiftAndSet(status, 2)));
    }
    memo[x][y][introvertsCount][extrovertsCount][status] = result;
    return result;
  }

  private int shiftAndSet(int status, int b) {
    return  (int) ((status * 3 + b) % (Math.pow(3, n)));
  }

  private int[] nextPosition(int x, int y) {
    if (y == n - 1) {
      return new int[] {x + 1, 0};
    }
    return new int[] {x, y + 1};
  }

}