package question1548_the_most_similar_path_in_a_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  private Set<Integer>[] graph;

  private List<Integer> result = new ArrayList<>();

  private int[][] memo;

  public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
    graph = new Set[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new HashSet<>();
    }
    for (int[] road : roads) {
      graph[road[0]].add(road[1]);
      graph[road[1]].add(road[0]);
    }
    memo = new int[n][targetPath.length];
    for (int i = 0; i < memo.length; i++) {
      Arrays.fill(memo[i], -1);
    }
    int minDistance = Integer.MAX_VALUE;
    int start = -1;
    for (int i = 0; i < n; i++) {
      int tmpDistance = mostSimilar(names, targetPath, i, 0);
      if (minDistance > tmpDistance) {
        minDistance = tmpDistance;
        start = i;
      }
    }
    result.add(start);
    while (result.size() < targetPath.length) {
      int index = result.size() - 1;
      int last = result.get(index);
      if (!names[last].equals(targetPath[index])) {
        minDistance--;
      }
      for (int i = 0; i < n; i++) {
        if (mostSimilar(names, targetPath, i, index + 1) == minDistance && graph[last].contains(i)) {
          result.add(i);
          break;
        }
      }
    }
    return result;
  }

  /**
   * 以节点 i 为起点，寻找 targetPath 中 [j, targetPath.length - 1] 范围内最相似路径的最小编辑距离
   */
  private int mostSimilar(String[] names, String[] targetPath, int i, int j) {
    if (j >= targetPath.length) {
      return 0;
    }
    if (-1 != memo[i][j]) {
      return memo[i][j];
    }
    memo[i][j] = Integer.MAX_VALUE;
    int diff = 0;
    if (!names[i].equals(targetPath[j])) {
      diff++;
    }
    for (int next : graph[i]) {
      memo[i][j] = Math.min(memo[i][j], diff + mostSimilar(names, targetPath, next, j + 1));

    }
    return memo[i][j];
  }

}