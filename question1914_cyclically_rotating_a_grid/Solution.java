package question1914_cyclically_rotating_a_grid;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private int m, n;

  public int[][] rotateGrid(int[][] grid, int k) {
    m = grid.length;
    n = grid[0].length;
    int levels = Math.min(m, n) / 2;
    for (int i = 0; i < levels; i++) {
      rotateGrid(grid, k, i);
    }
    return grid;
  }

  private void rotateGrid(int[][] grid, int k, int level) {
    List<Integer> list = new ArrayList<>();
    for (int i = level; i <= n - level - 1; i++) {
      list.add(grid[level][i]);
    }
    for (int i = level + 1; i <= m - level - 1; i++) {
      list.add(grid[i][n - level - 1]);
    }
    for (int i = n - level - 2; i >= level; i--) {
      list.add(grid[m - level - 1][i]);
    }
    for (int i = m - level - 2; i > level; i--) {
      list.add(grid[i][level]);
    }
    k %= list.size();
    int index = k;
    for (int i = level; i <= n - level - 1; i++) {
      grid[level][i] = list.get(index++);
      if (index == list.size()) {
        index = 0;
      }
    }
    for (int i = level + 1; i <= m - level - 1; i++) {
      grid[i][n - level - 1] = list.get(index++);
      if (index == list.size()) {
        index = 0;
      }
    }
    for (int i = n - level - 2; i >= level; i--) {
      grid[m - level - 1][i] = list.get(index++);
      if (index == list.size()) {
        index = 0;
      }
    }
    for (int i = m - level - 2; i > level; i--) {
      grid[i][level] = list.get(index++);
      if (index == list.size()) {
        index = 0;
      }
    }
  }

}