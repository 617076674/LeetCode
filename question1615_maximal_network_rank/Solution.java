package question1615_maximal_network_rank;

public class Solution {

  public int maximalNetworkRank(int n, int[][] roads) {
    boolean[][] graph = new boolean[n][n];
    int[] edges = new int[n];
    for (int[] road : roads) {
      graph[road[0]][road[1]] = true;
      graph[road[1]][road[0]] = true;
      edges[road[0]]++;
      edges[road[1]]++;
    }
    int result = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int temp = edges[i] + edges[j];
        if (graph[i][j]) {
          temp--;
        }
        result = Math.max(result, temp);
      }
    }
    return result;
  }

}