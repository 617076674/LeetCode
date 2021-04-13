package question0886_possible_bipartition;

public class Solution {

  private boolean[][] graph;

  private int[] color;

  public boolean possibleBipartition(int N, int[][] dislikes) {
    graph = new boolean[N][N];
    for (int[] edge : dislikes) {
      graph[edge[0] - 1][edge[1] - 1] = graph[edge[1] - 1][edge[0] - 1] = true;
    }
    color = new int[N];
    for (int node = 0; node < N; node++) {
      if (color[node] == 0 && !dfs(node, 1)) {
        return false;
      }
    }
    return true;
  }

  public boolean dfs(int node, int c) {
    if (color[node] != 0) {
      return color[node] == c;
    }
    color[node] = c;
    for (int i = 0; i < graph[node].length; i++) {
      if (graph[node][i] && !dfs(i, -c)) {
        return false;
      }
    }
    return true;
  }

}