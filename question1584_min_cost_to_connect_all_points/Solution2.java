package question1584_min_cost_to_connect_all_points;

import java.util.Arrays;

public class Solution2 {

  public int minCostConnectPoints(int[][] points) {
    int[] distances = new int[points.length];
    Arrays.fill(distances, Integer.MAX_VALUE);
    boolean[] visited = new boolean[points.length];
    visited[0] = true;
    for (int i = 1; i < points.length; i++) {
      distances[i] = calculateDistance(points, i, 0);
    }
    int result = 0;
    for (int i = 1; i < points.length; i++) {
      int v = -1, min = Integer.MAX_VALUE;
      for (int j = 0; j < points.length; j++) {
        if (!visited[j] && distances[j] < min) {
          min = distances[j];
          v = j;
        }
      }
      result += min;
      visited[v] = true;
      for (int j = 0; j < points.length; j++) {
        if (!visited[j] && calculateDistance(points, j, v) < distances[j]) {
          distances[j] = calculateDistance(points, j, v);
        }
      }
    }
    return result;
  }

  private static int calculateDistance(int[][] points, int x, int y) {
    return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
  }

}
