package question1627_graph_connectivity_with_threshold;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private static class UnionFind {

    private int[] parent;

    public UnionFind(int n) {
      this.parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    public void union(int a, int b) {
      int aParent = findParent(a), bParent = findParent(b);
      if (aParent != bParent) {
        parent[aParent] = bParent;
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

  }

  public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
    UnionFind unionFind = new UnionFind(n + 1);
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= Math.sqrt(i); j++) {
        if (i % j == 0) {
          if (j > threshold) {
            unionFind.union(i, j);
          }
          int temp = i / j;
          if (temp > threshold) {
            unionFind.union(i, temp);
          }
        }
      }
    }
    List<Boolean> result = new ArrayList<>();
    for (int[] query : queries) {
      result.add(unionFind.findParent(query[0]) == unionFind.findParent(query[1]));
    }
    return result;
  }

}