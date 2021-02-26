package question1489_find_critical_and_pseudo_critical_edges_in_minimum_spanning_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

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

  private static class Edge {

    int index;

    int node1;

    int node2;

    int len;

    public Edge(int index, int node1, int node2, int len) {
      this.index = index;
      this.node1 = node1;
      this.node2 = node2;
      this.len = len;
    }

  }

  public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
    int m = edges.length;
    Edge[] newEdges = new Edge[m];
    for (int i = 0; i < m; i++) {
      newEdges[i] = new Edge(i, edges[i][0], edges[i][1], edges[i][2]);
    }
    Arrays.sort(newEdges, Comparator.comparingInt(edge -> edge.len));
    UnionFind unionFind = new UnionFind(n);
    int value = 0;
    for (int i = 0; i < m; i++) {
      if (unionFind.union(newEdges[i].node1, newEdges[i].node2)) {
        value += newEdges[i].len;
      }
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < 2; ++i) {
      result.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      unionFind = new UnionFind(n);
      int v = 0;
      for (int j = 0; j < m; ++j) {
        if (i != j && unionFind.union(newEdges[j].node1, newEdges[j].node2)) {
          v += newEdges[j].len;
        }
      }
      if (unionFind.setCount != 1 || v > value) {
        result.get(0).add(newEdges[i].index); // 是关键边
        continue;
      }
      unionFind = new UnionFind(n);
      unionFind.union(newEdges[i].node1, newEdges[i].node2);
      v = newEdges[i].len;
      for (int j = 0; j < m; j++) {
        if (i != j && unionFind.union(newEdges[j].node1, newEdges[j].node2)) {
          v += newEdges[j].len;
        }
      }
      if (v == value) {
        result.get(1).add(newEdges[i].index); // 是伪关键边
      }
    }
    return result;
  }

}