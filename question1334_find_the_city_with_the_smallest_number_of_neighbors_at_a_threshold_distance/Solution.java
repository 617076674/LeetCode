package question1334_find_the_city_with_the_smallest_number_of_neighbors_at_a_threshold_distance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  private int[][] graph;

  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    graph = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(graph[i], Integer.MAX_VALUE);
    }
    for (int[] edge : edges) {
      graph[edge[0]][edge[1]] = graph[edge[1]][edge[0]] = edge[2];
    }
    int cities = n, result = -1;
    for (int i = 0; i < n; i++) {
      boolean[] visited = new boolean[n];
      dijkstra(graph[i], i, visited);
      int temp = 0;
      for (int j = 0; j < n; j++) {
        if (i != j && graph[i][j] <= distanceThreshold) {
          temp++;
        }
      }
      if (temp <= cities) {
        cities = temp;
        result = i;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
    System.out.println(new Solution().findTheCity(4, edges, 4));
  }

  private void dijkstra(int[] distance, int begin, boolean[] visited) {
    distance[begin] = 0;
    Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(index -> distance[index]));
    queue.add(begin);
    while (!queue.isEmpty()) {
      int u = queue.poll();
      if (visited[u]) {
        continue;
      }
      visited[u] = true;
      for (int v = 0; v < graph.length; v++) {
        if (graph[u][v] != Integer.MAX_VALUE) {
          distance[v] = Math.min(distance[v], distance[u] + graph[u][v]);
          queue.add(v);
        }
      }
    }
  }

}