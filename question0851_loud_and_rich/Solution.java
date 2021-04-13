package question0851_loud_and_rich;

import java.util.Arrays;

public class Solution {

  private boolean[][] graph;

  private int n;

  private int[] memo;

  public int[] loudAndRich(int[][] richer, int[] quiet) {
    n = quiet.length;
    graph = new boolean[n][n];
    for (int[] relation : richer) {
      graph[relation[1]][relation[0]] = true;
    }
    memo = new int[n];
    Arrays.fill(memo, -1);
    for (int i = 0; i < n; i++) {
      memo[i] = getQuietest(i, quiet);
    }
    return memo;
  }

  private int getQuietest(int now, int[] quiet) {
    if (memo[now] != -1) {
      return memo[now];
    }
    int result = now;
    for (int i = 0; i < n; i++) {
      if (graph[now][i]) {
        int temp = getQuietest(i, quiet);
        if (quiet[temp] < quiet[result]) {
          result = temp;
        }
      }
    }
    memo[now] = result;
    return result;
  }

}