package question0913_cat_and_mouse;

public class Solution {

  private Integer[][][] memo;

  public int catMouseGame(int[][] graph) {
    memo = new Integer[graph.length * 2][graph.length][graph.length];
    return catMouseGame(graph, 0, 1, 2);
  }

  private int catMouseGame(int[][] graph, int t, int x, int y) {
    if (t == graph.length * 2) {
      return 0; // 平局
    }
    if (x == y) {
      return 2; // 猫赢
    }
    if (x == 0) {
      return 1; // 鼠赢
    }
    if (null != memo[t][x][y]) {
      return memo[t][x][y];
    }
    if ((t & 1) == 0) {
      // 老鼠走
      boolean catWin = true;
      for (int i = 0; i < graph[x].length; i++) {
        int nextX = graph[x][i];
        int result = catMouseGame(graph, t + 1, nextX, y);
        if (result == 1) {
          memo[t][x][y] = 1;
          return 1;
        }
        if (result != 2) {
          catWin = false;
        }
      }
      if (catWin) {
        memo[t][x][y] = 2;
        return 2;
      }
      memo[t][x][y] = 0;
      return 0;
    }
    // 猫走
    boolean mouseWin = true;
    for (int i = 0; i < graph[y].length; i++) {
      int nextY = graph[y][i];
      if (nextY == 0) {
        continue;
      }
      int result = catMouseGame(graph, t + 1, x, nextY);
      if (result == 2) {
        memo[t][x][y] = 2;
        return 2;
      }
      if (result != 1) {
        mouseWin = false;
      }
    }
    if (mouseWin) {
      memo[t][x][y] = 1;
      return 1;
    }
    memo[t][x][y] = 0;
    return 0;
  }

}