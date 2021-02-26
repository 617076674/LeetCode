package question1579_remove_max_number_of_edges_to_keep_graph_fully_traversable;

public class Solution {

  private static class UnionFind {

    int[] parent;

    int n;

    // 当前连通分量数目
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

  public int maxNumEdgesToRemove(int n, int[][] edges) {
    UnionFind unionFind1 = new UnionFind(n), unionFind2 = new UnionFind(n);
    int result = 0;
    for (int[] edge : edges) {
      if (edge[0] == 3) {
        if (!unionFind1.union(edge[1] - 1, edge[2] - 1)) {
          ++result;
        } else {
          unionFind2.union(edge[1] - 1, edge[2] - 1);
        }
      }
    }
    for (int[] edge : edges) {
      if ((edge[0] == 1 && !unionFind1.union(edge[1] - 1, edge[2] - 1))
          || (edge[0] == 2 && !unionFind2.union(edge[1] - 1, edge[2] - 1))) {
        ++result;
      }
    }
    if (unionFind1.setCount != 1 || unionFind2.setCount != 1) {
      return -1;
    }
    return result;
  }

}