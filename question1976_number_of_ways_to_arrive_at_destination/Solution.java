package question1976_number_of_ways_to_arrive_at_destination;

import java.util.Arrays;

public class Solution {

  private static final int MOD = 1000000007;

  public int countPaths(int n, int[][] roads) {
    long[][] graph = new long[n][n];
    for (int[] road : roads) {
      graph[road[0]][road[1]] = graph[road[1]][road[0]] = road[2];
    }
    long[] distance = new long[n];
    int[] minRoads = new int[n];
    minRoads[0] = 1;
    Arrays.fill(distance, Long.MAX_VALUE);
    distance[0] = 0;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      int u = -1;
      long minDistance = Long.MAX_VALUE;
      for (int j = 0; j < n; j++) {
        if (!visited[j] && distance[j] < minDistance) {
          minDistance = distance[j];
          u = j;
        }
      }
      if (u == -1) {
        break;
      }
      visited[u] = true;
      for (int v = 0; v < n; v++) {
        if (graph[u][v] == 0 || visited[v]) {
          continue;
        }
        if (distance[v] > distance[u] + graph[u][v]) {
          distance[v] = distance[u] + graph[u][v];
          minRoads[v] = minRoads[u];
        } else if (distance[v] == distance[u] + graph[u][v]) {
          minRoads[v] += minRoads[u];
          minRoads[v] %= MOD;
        }
      }
    }
    return minRoads[n - 1];
  }

}