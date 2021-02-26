package question0803_bricks_falling_when_hit;

import java.util.Arrays;

public class Solution {

  private int[] parent;

  private int[] groupSize;

  public int[] hitBricks(int[][] grid, int[][] hits) {
    int m = grid.length, n = grid[0].length;
    parent = new int[m * n + 1];
    groupSize = new int[m * n + 1];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
      groupSize[i] = 1;
    }
    int[] result = new int[hits.length];
    Arrays.fill(result, -1);
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int i = 0; i < hits.length; i++) {
      if (grid[hits[i][0]][hits[i][1]] == 0) {
        result[i] = 0;
      } else {
        grid[hits[i][0]][hits[i][1]] = 0;
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          for (int[] direction : directions) {
            int newI = i + direction[0], newJ = j + direction[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == 1) {
              union(i * n + j, newI * n + newJ);
            }
          }
        }
      }
    }
    for (int i = 0; i < n; i++) {
      if (grid[0][i] == 1) {
        union(i, m * n);
      }
    }
    int curSize = groupSize[m * n];
    for (int i = hits.length - 1; i >= 0; i--) {
      if (result[i] != 0) {
        grid[hits[i][0]][hits[i][1]] = 1;
        if (hits[i][0] == 0) {
          union(hits[i][1], m * n);
        }
        for (int[] direction : directions) {
          int newI = hits[i][0] + direction[0], newJ = hits[i][1] + direction[1];
          if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == 1) {
            union(hits[i][0] * n + hits[i][1], newI * n + newJ);
          }
        }
        result[i] = Math.max(0, groupSize[m * n] - curSize - 1);
        curSize = groupSize[m * n];
      }
    }
    return result;
  }

  private int findParent(int x) {
    int a = x;
    while (x != parent[x]) {
      x = parent[x];
    }
    while (a != parent[a]) {
      int z = parent[a];
      parent[a] = x;
      a = z;
    }
    return x;
  }

  private void union(int a, int b) {
    int aParent = findParent(a), bParent = findParent(b);
    if (aParent < bParent) {
      parent[aParent] = bParent;
      groupSize[bParent] = groupSize[aParent] + groupSize[bParent];
      groupSize[aParent] = 0;
    } else if (aParent > bParent) {
      parent[bParent] = aParent;
      groupSize[aParent] = groupSize[bParent] + groupSize[aParent];
      groupSize[bParent] = 0;
    }
  }

}