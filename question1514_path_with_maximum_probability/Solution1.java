package question1514_path_with_maximum_probability;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {

  private static class Edge {
    int node;
    double weight;

    public Edge(int node, double weight) {
      this.node = node;
      this.weight = weight;
    }
  }

  private Set<Edge>[] graph;

  private Double[] distance;

  private int start;

  private boolean[] visited;

  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    graph = new Set[n];
    for (int i = 0; i < edges.length; i++) {
      if (null == graph[edges[i][0]]) {
        graph[edges[i][0]] = new HashSet<>();
      }
      graph[edges[i][0]].add(new Edge(edges[i][1], succProb[i]));
      if (null == graph[edges[i][1]]) {
        graph[edges[i][1]] = new HashSet<>();
      }
      graph[edges[i][1]].add(new Edge(edges[i][0], succProb[i]));
    }
    this.start = start;
    distance = new Double[n];
    visited = new boolean[n];
    dijkstra();
    return distance[end];
  }

  private void dijkstra() {
    Arrays.fill(distance, 0.0);
    distance[start] = 1.0;
    for (int i = 0; i < distance.length - 1; i++) {
      int u = -1;
      double max = 0.0;
      for (int j = 0; j < distance.length; j++) {
        if (!visited[j] && distance[j] > max) {
          max = distance[j];
          u = j;
        }
      }
      if (u == -1) {
        return;
      }
      visited[u] = true;
      if (null == graph[u]) {
        return;
      }
      for (Edge edge : graph[u]) {
        if (!visited[edge.node]) {
          distance[edge.node] = Math.max(distance[edge.node], distance[u] * edge.weight);
        }
      }
    }
  }

}