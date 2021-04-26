package question1267_count_servers_that_communicate;

public class Solution {

  public int countServers(int[][] grid) {
    boolean[] rows = new boolean[grid.length], cols = new boolean[grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      int count = 0;
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          count++;
        }
      }
      rows[i] = count > 1;
    }
    for (int j = 0; j < grid[0].length; j++) {
      int count = 0;
      for (int i = 0; i < grid.length; i++) {
        if (grid[i][j] == 1) {
          count++;
        }
      }
      cols[j] = count > 1;
    }
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if ((rows[i] || cols[j]) && grid[i][j] == 1) {
          result++;
        }
      }
    }
    return result;
  }

}