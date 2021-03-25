package question0785_is_graph_bipartite;

public class Solution {

  private int[] color;

  public boolean isBipartite(int[][] graph) {
    color = new int[graph.length];
    for (int i = 0; i < color.length; i++) {
      if (color[i] == 0) {
        dfs(i, graph, -1);
      }
    }
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[i].length; j++) {
        int node1 = i, node2 = graph[i][j];
        if (color[node1] == color[node2]) {
          return false;
        }
      }
    }
    return true;
  }

  private void dfs(int now, int[][] graph, int pre) {
    if (pre == -1) {
      color[now] = 1;
    } else if (color[pre] == 1) {
      color[now] = 2;
    } else {
      color[now] = 1;
    }
    for (int i = 0; i < graph[now].length; i++) {
      int next = graph[now][i];
      if (color[next] == 0) {
        dfs(graph[now][i], graph, now);
      }
    }
  }

}