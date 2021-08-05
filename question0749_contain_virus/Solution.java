package question0749_contain_virus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  private Set<Integer> seen;

  private List<Set<Integer>> regions;

  private List<Set<Integer>> frontiers;

  private List<Integer> perimeters;

  private int[][] grid;

  private int m, n;

  private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public int containVirus(int[][] grid) {
    this.grid = grid;
    m = grid.length;
    n = grid[0].length;
    int result = 0;
    while (true) {
      seen = new HashSet<>();
      regions = new ArrayList<>();
      frontiers = new ArrayList<>();
      perimeters = new ArrayList<>();
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          if (grid[i][j] == 1 && !seen.contains(i * n + j)) {
            regions.add(new HashSet<>());
            frontiers.add(new HashSet<>());
            perimeters.add(0);
            dfs(i, j);
          }
        }
      }
      if (regions.isEmpty()) {
        break;
      }
      int triageIndex = 0;
      for (int i = 0; i < frontiers.size(); ++i) {
        if (frontiers.get(triageIndex).size() < frontiers.get(i).size()) {
          triageIndex = i;
        }
      }
      result += perimeters.get(triageIndex);
      for (int i = 0; i < regions.size(); ++i) {
        if (i == triageIndex) {
          for (int code : regions.get(i)) {
            grid[code / n][code % n] = -1;
          }
        } else {
          for (int code : regions.get(i)) {
            int r = code / n, c = code % n;
            for (int k = 0; k < 4; ++k) {
              int nr = r + directions[k][0], nc = c + directions[k][1];
              if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                grid[nr][nc] = 1;
              }
            }
          }
        }
      }
    }
    return result;
  }

  public void dfs(int r, int c) {
    if (seen.contains(r * n + c)) {
      return;
    }
    seen.add(r * n + c);
    int regionIndex = regions.size() - 1;
    regions.get(regionIndex).add(r * n + c);
    for (int k = 0; k < 4; ++k) {
      int nr = r + directions[k][0], nc = c + directions[k][1];
      if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
        if (grid[nr][nc] == 1) {
          dfs(nr, nc);
        } else if (grid[nr][nc] == 0) {
          frontiers.get(regionIndex).add(nr * n + nc);
          perimeters.set(regionIndex, perimeters.get(regionIndex) + 1);
        }
      }
    }
  }

}