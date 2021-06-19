package lcs03_YesdPw;

public class Solution {
  private boolean[][] visited = new boolean[501][501];

  private static class Flag {
    boolean value = true;
  }

  public int largestArea(String[] grid) {
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length(); j++) {
        if (!visited[i][j] && grid[i].charAt(j) != '0') {
          Flag flag = new Flag();
          int temp = dfs(grid, i, j, flag);
          if (flag.value) {
            result = Math.max(result, temp);
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String[] grid = {"113415514", "124112542", "313225220", "253354005", "352014331", "304514425"
        , "553313413", "532352143", "220340311", "245210141"};
    System.out.println(new Solution().largestArea(grid));
  }

  private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private int dfs(String[] grid, int x, int y, Flag flag) {
    if (x == 0 || (y < grid[x - 1].length() && grid[x - 1].charAt(y) == '0')
        || x == grid.length - 1 || (y < grid[x + 1].length() && grid[x + 1].charAt(y) == '0')
        || y == 0 || (grid[x].charAt(y - 1) == '0') || y == grid[x].length() - 1
        || grid[x].charAt(y + 1) == '0') {
      flag.value = false;
    }
    int result = 1;
    visited[x][y] = true;
    for (int[] direction : directions) {
      int newX = x + direction[0], newY = y + direction[1];
      if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[newX].length()
          && !visited[newX][newY] && grid[x].charAt(y) == grid[newX].charAt(newY)) {
        result += dfs(grid, newX, newY, flag);
      }
    }
    return result;
  }

}