package question1319_number_of_operations_to_make_network_connected;

public class Solution {

  public int makeConnected(int n, int[][] connections) {
    if (connections.length < n - 1) {
      return -1;
    }
    UnionFind unionFind = new UnionFind(n);
    for (int[] connection : connections) {
      unionFind.union(connection[0], connection[1]);
    }
    return unionFind.setCount - 1;
  }

  private static class UnionFind {

    int[] parent;

    int n;

    int setCount;

    public UnionFind(int n) {
      this.n = n;
      this.setCount = n;
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
        setCount--;
        return true;
      }
      return false;
    }

  }

}