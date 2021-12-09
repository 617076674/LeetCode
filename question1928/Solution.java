package question1928;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {

  private static class Edge {

    int node1, node2, time;

    public Edge(int node1, int node2, int time) {
      this.node1 = node1;
      this.node2 = node2;
      this.time = time;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Edge edge = (Edge) o;
      return node1 == edge.node1 &&
          node2 == edge.node2;
    }

    @Override
    public int hashCode() {
      return Objects.hash(node1, node2);
    }

  }

  private int[][] originGraph;

  private Set<Edge>[] graph;

  private int[] passingFees;

  private Integer[][] memo;

  private int result = Integer.MAX_VALUE / 2;

  public int minCost(int maxTime, int[][] edges, int[] passingFees) {
    originGraph = new int[passingFees.length][passingFees.length];
    for (int[] edge : edges) {
      if (originGraph[edge[0]][edge[1]] == 0) {
        originGraph[edge[0]][edge[1]] = originGraph[edge[1]][edge[0]] = edge[2];
      } else {
        originGraph[edge[0]][edge[1]] = originGraph[edge[1]][edge[0]] = Math.min(edge[2],
            originGraph[edge[1]][edge[0]]);
      }
    }
    graph = new HashSet[passingFees.length];
    for (int i = 0; i < originGraph.length; i++) {
      for (int j = 0; j < originGraph.length; j++) {
        if (originGraph[i][j] > 0) {
          if (null == graph[i]) {
            graph[i] = new HashSet<>();
          }
          graph[i].add(new Edge(i, j, originGraph[i][j]));
        }
      }
    }
    this.passingFees = passingFees;
    memo = new Integer[maxTime + 1][passingFees.length];
    for (int i = 1; i <= maxTime; i++) {
      result = Math.min(result, minCostHelper(i, 0));
    }
    return result >= Integer.MAX_VALUE / 2 ? -1 : result;
  }

  // 从 cur 移动至 n - 1 需要的时间为 t，所需的最小花费
  private int minCostHelper(int t, int cur) {
    if (cur == passingFees.length - 1 && t == 0) {
      return passingFees[passingFees.length - 1];
    }
    if (memo[t][cur] != null) {
      return memo[t][cur];
    }
    int result = Integer.MAX_VALUE / 2;
    for (Edge edge : graph[cur]) {
      if (t >= edge.time) {
        result = Math.min(result, passingFees[cur] + minCostHelper(t - edge.time, edge.node2));
      }
    }
    memo[t][cur] = result;
    return result;
  }

}