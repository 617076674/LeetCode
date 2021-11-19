package question1494;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javafx.util.Pair;

public class Solution {

  private boolean[][] graph;

  private int[] inDegree;

  private static List<Pair<List<Integer>, List<Integer>>>[] allPairs = new ArrayList[16];

  private Integer[] memo = new Integer[1 << 15];

  public int minNumberOfSemesters(int n, int[][] relations, int k) {
    inDegree = new int[n];
    graph = new boolean[n][n];
    for (int[] relation : relations) {
      int before = relation[0] - 1, after = relation[1] - 1;
      graph[before][after] = true;
      inDegree[after]++;
    }
    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }
    for (int i = k + 1; i <= n; i++) {
      allPairs[i] = new Helper().generateAllList(i, k);
    }
    return dfs(queue, k, 0);
  }

  private int dfs(LinkedList<Integer> queue, int k, int status) {
    if (queue.isEmpty()) {
      return 0;
    }
    if (null != memo[status]) {
      return memo[status];
    }
    int qSize = queue.size();
    if (qSize <= k) {
      int nextStatus = status;
      for (int i = 0; i < qSize; i++) {
        int cur = queue.poll();
        nextStatus |= (1 << cur);
        for (int j = 0; j < graph[cur].length; j++) {
          if (graph[cur][j]) {
            inDegree[j]--;
            if (inDegree[j] == 0) {
              queue.add(j);
            }
          }
        }
      }
      memo[status] = dfs(queue, k, nextStatus) + 1;
      return memo[status];
    }
    int result = Integer.MAX_VALUE;
    List<Pair<List<Integer>, List<Integer>>> allPairs = Solution.allPairs[queue.size()];
    for (Pair<List<Integer>, List<Integer>> pair : allPairs) {
      LinkedList<Integer> nextQueue = new LinkedList<>();
      int[] copyInDegree = new int[inDegree.length];
      System.arraycopy(inDegree, 0, copyInDegree, 0, inDegree.length);
      int nextStatus = status;
      for (int i = 0; i < k; i++) {
        int cur = queue.get(pair.getKey().get(i));
        nextStatus |= (1 << cur);
        for (int j = 0; j < graph[cur].length; j++) {
          if (graph[cur][j]) {
            inDegree[j]--;
            if (inDegree[j] == 0) {
              nextQueue.add(j);
            }
          }
        }
      }
      for (int i = 0; i < pair.getValue().size(); i++) {
        nextQueue.add(queue.get(pair.getValue().get(i)));
      }
      result = Math.min(result, dfs(nextQueue, k, nextStatus) + 1);
      System.arraycopy(copyInDegree, 0, inDegree, 0, inDegree.length);
    }
    memo[status] = result;
    return result;
  }

  private static class Helper {

    private List<Pair<List<Integer>, List<Integer>>> result = new ArrayList<>();

    private int k;

    private int n;

    private List<Pair<List<Integer>, List<Integer>>> generateAllList(int n, int k) {
      this.k = k;
      this.n = n;
      dfs(0, new ArrayList<>(), new ArrayList<>());
      return result;
    }

    private void dfs(int index, List<Integer> remainedList,
                     List<Integer> removedList) {
      if (index == n) {
        if (remainedList.size() == k) {
          result.add(new Pair<>(new ArrayList<>(remainedList), new ArrayList<>(removedList)));
        }
        return;
      }
      removedList.add(index);
      dfs(index + 1, remainedList, removedList);
      removedList.remove(removedList.size() - 1);
      remainedList.add(index);
      dfs(index + 1, remainedList, removedList);
      remainedList.remove(remainedList.size() - 1);
    }

  }

}