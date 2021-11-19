package question0827_making_a_large_island;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  private static class UnionFind {

    int[] parent;

    int n;

    int setCount;

    public UnionFind(int n) {
      this.n = n;
      this.parent = new int[n];
      this.setCount = n;
      for (int i = 0; i < n; ++i) {
        parent[i] = i;
      }
    }

    public int findParent(int x) {
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

    public boolean union(int a, int b) {
      int aParent = findParent(a), bParent = findParent(b);
      if (aParent != bParent) {
        parent[aParent] = bParent;
        setCount--;
        return true;
      }
      return false;
    }

  }

  public int largestIsland(int[][] grid) {
    int n = grid.length;
    UnionFind unionFind = new UnionFind(n * n);
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          for (int[] direction : directions) {
            int nextI = i + direction[0], nextJ = j + direction[1];
            if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n && grid[nextI][nextJ] == 1) {
              unionFind.union(i * n + j, nextI * n + nextJ);
            }
          }
        }
      }
    }
    int[] count = new int[n * n];
    for (int i = 0; i < unionFind.parent.length; i++) {
      count[unionFind.findParent(i)]++;
    }
    int result = 0;
    for (int i = 0; i < count.length; i++) {
      result = Math.max(result, count[i]);
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) {
          int temp = 1;
          Set<Integer> set = new HashSet<>();
          for (int[] direction : directions) {
            int nextI = i + direction[0], nextJ = j + direction[1];
            if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n && grid[nextI][nextJ] == 1) {
              int parent = unionFind.findParent(nextI * n + nextJ);
              if (!set.contains(parent)) {
                temp += count[parent];
                set.add(parent);
              }
            }
          }
          result = Math.max(result, temp);
        }
      }
    }
    return result;
  }

}