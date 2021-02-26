package question1584_min_cost_to_connect_all_points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution1 {

  private static class Edge {

    int len;

    int a;

    int b;

    public Edge(int len, int a, int b) {
      this.len = len;
      this.a = a;
      this.b = b;
    }

  }

  private int[] parent;

  public int minCostConnectPoints(int[][] points) {
    parent = new int[points.length];
    for (int i = 0; i < points.length; i++) {
      parent[i] = i;
    }
    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        edges.add(new Edge(calculateDistance(points, i, j), i, j));
      }
    }
    Collections.sort(edges, Comparator.comparingInt(edge -> edge.len));
    int result = 0, num = 1;
    for (Edge edge : edges) {
      int aParent = findParent(edge.a), bParent = findParent(edge.b);
      if (aParent != bParent) {
        parent[aParent] = bParent;
        result += edge.len;
        num++;
        if (num == points.length) {
          break;
        }
      }
    }
    return result;
  }

  private static int calculateDistance(int[][] points, int x, int y) {
    return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
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

}