package question1617_count_subtrees_with_max_distance_between_cities;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
    int[] result = new int[n - 1];
    for (int status = 1; status < (1 << n); status++) {
      boolean[][] graph = new boolean[n][n];
      Set<Integer> nodeSet = new HashSet<>();
      for (int i = 0; i < n; i++) {
        if ((status & (1 << i)) != 0) {
          nodeSet.add(i);
        }
      }
      for (int[] edge : edges) {
        int node1 = edge[0] - 1, node2 = edge[1] - 1;
        if (nodeSet.contains(node1) && nodeSet.contains(node2)) {
          graph[node1][node2] = graph[node2][node1] = true;
        }
      }
      if (isTree(graph, nodeSet)) {
        int diameter = calculateDiameter(graph, nodeSet);
        if (diameter > 0) {
          result[diameter - 1]++;
        }
      }
    }
    return result;
  }

  private boolean isTree(boolean[][] graph, Set<Integer> nodeSet) {
    boolean[] visited = new boolean[graph.length];
    Queue<Integer> queue = new LinkedList<>();
    int begin = nodeSet.iterator().next();
    queue.add(begin);
    visited[begin] = true;
    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (int i = 0; i < graph.length; i++) {
        if (!visited[i] && graph[i][now]) {
          queue.add(i);
          visited[i] = true;
        }
      }
    }
    for (int i = 0; i < graph.length; i++) {
      if (nodeSet.contains(i) && !visited[i]) {
        return false;
      }
    }
    return true;
  }

  private int calculateDiameter(boolean[][] graph, Set<Integer> nodeSet) {
    boolean[] visited = new boolean[graph.length];
    Queue<Integer> queue = new LinkedList<>();
    int begin = nodeSet.iterator().next();
    queue.add(begin);
    visited[begin] = true;
    int lastNode = -1;
    while (!queue.isEmpty()) {
      int now = queue.poll();
      lastNode = now;
      for (int i = 0; i < graph.length; i++) {
        if (!visited[i] && graph[i][now]) {
          queue.add(i);
          visited[i] = true;
        }
      }
    }
    visited = new boolean[graph.length];
    visited[lastNode] = true;
    queue.add(lastNode);
    int len = 0;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int now = queue.poll();
        for (int j = 0; j < graph.length; j++) {
          if (!visited[j] && graph[j][now]) {
            queue.add(j);
            visited[j] = true;
          }
        }
      }
      len++;
    }
    return len - 1;
  }

}