package question0778_swim_in_rising_water;

public class Solution {

  private static class UnionFind {

    int[] parent;

    int n;

    public UnionFind(int n) {
      this.n = n;
      this.parent = new int[n];
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
        return true;
      }
      return false;
    }

  }

  public int swimInWater(int[][] grid) {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int n = grid.length;
    int left = 0, right = n * n - 1;
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      UnionFind unionFind = new UnionFind(n * n);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          for (int k = 0; k < directions.length; k++) {
            int newI = i + directions[k][0], newJ = j + directions[k][1];
            if (newI >= 0 && newI < n && newJ >= 0 && newJ < n && grid[newI][newJ] <= mid && grid[i][j] <= mid) {
              unionFind.union(i * n + j, newI * n + newJ);
            }
          }
        }
      }
      if (unionFind.findParent(0) == unionFind.findParent(n * n - 1)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

}