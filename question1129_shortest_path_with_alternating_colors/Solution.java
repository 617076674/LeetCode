package question1129_shortest_path_with_alternating_colors;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
    boolean[][] graphRed = new boolean[n][n], graphBlue = new boolean[n][n];
    for (int[] redEdge : red_edges) {
      graphRed[redEdge[0]][redEdge[1]] = true;
    }
    for (int[] blueEdge : blue_edges) {
      graphBlue[blueEdge[0]][blueEdge[1]] = true;
    }
    int[] result = new int[n];
    Arrays.fill(result, Integer.MAX_VALUE);
    boolean[][] visitedRed = new boolean[n][n], visitedBlue = new boolean[n][n];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {0, 0});
    queue.add(new int[] {0, 1});
    int distance = 1;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int[] cur = queue.poll();
        if (cur[1] == 0) {
          for (int j = 0; j < n; j++) {
            if (!visitedRed[cur[0]][j] && graphRed[cur[0]][j]) {
              visitedRed[cur[0]][j] = true;
              result[j] = Math.min(result[j], distance);
              queue.add(new int[] {j, 1});
            }
          }
        } else {
          for (int j = 0; j < n; j++) {
            if (!visitedBlue[cur[0]][j] && graphBlue[cur[0]][j]) {
              visitedBlue[cur[0]][j] = true;
              result[j] = Math.min(result[j], distance);
              queue.add(new int[] {j, 0});
            }
          }
        }
      }
      distance++;
    }
    result[0] = 0;
    for (int i = 1; i < n; i++) {
      if (result[i] == Integer.MAX_VALUE) {
        result[i] = -1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int n = 5;
    int[][] red_edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
    int[][] blue_edges = {{1, 2}, {2, 3}, {3, 1}};
    System.out.println(Arrays.toString(new Solution().shortestAlternatingPaths(n, red_edges,
        blue_edges)));
  }

}