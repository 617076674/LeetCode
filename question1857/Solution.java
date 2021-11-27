package question1857;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public int largestPathValue(String colors, int[][] edges) {
    Set<Integer>[] graph = new HashSet[colors.length()];
    int[] inDegree = new int[colors.length()];
    for (int[] edge : edges) {
      if (null == graph[edge[0]]) {
        graph[edge[0]] = new HashSet<>();
      }
      graph[edge[0]].add(edge[1]);
      inDegree[edge[1]]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < colors.length(); i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }
    int[][] dp = new int[colors.length()][26];
    int visited = 0;
    while (!queue.isEmpty()) {
      visited++;
      int cur = queue.poll();
      dp[cur][colors.charAt(cur) - 'a']++;
      if (null != graph[cur]) {
        for (int next : graph[cur]) {
          for (int i = 0; i < 26; i++) {
            dp[next][i] = Math.max(dp[cur][i], dp[next][i]);
          }
          if (--inDegree[next] == 0) {
            queue.add(next);
          }
        }
      }
    }
    if (visited == colors.length()) {
      int result = 0;
      for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < 26; j++) {
          result = Math.max(result, dp[i][j]);
        }
      }
      return result;
    }
    return -1;
  }

}