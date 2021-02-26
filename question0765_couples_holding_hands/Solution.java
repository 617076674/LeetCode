package question0765_couples_holding_hands;

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

  public int minSwapsCouples(int[] row) {
    int n = row.length;
    UnionFind unionFind = new UnionFind(n);
    for (int i = 0; i < n; i += 2) {
      unionFind.union(i, i + 1);
    }
    for (int i = 0; i < n; i += 2) {
      unionFind.union(row[i], row[i + 1]);
    }
    return n / 2 - unionFind.setCount;
  }

}