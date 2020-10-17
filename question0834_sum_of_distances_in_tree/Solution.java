package question0834_sum_of_distances_in_tree;

import java.util.HashSet;
import java.util.Set;

/**
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 N。
 *
 * 执行用时：31ms，击败61.33%。消耗内存：47.9MB，击败11.95%。
 */
public class Solution {

  private Set<Integer>[] graph;

  private int[] nodeNum;

  private int[] result;

  public int[] sumOfDistancesInTree(int N, int[][] edges) {
    graph = new Set[N];
    for (int i = 0; i < N; i++) {
      graph[i] = new HashSet<>();
    }
    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }
    nodeNum = new int[N];
    result = new int[N];
    postOrder(0, -1);
    preOrder(0, -1, N);
    return result;
  }

  private void postOrder(int root, int parent) {
    nodeNum[root] = 1;
    for (int next : graph[root]) {
      if (next != parent) {
        postOrder(next, root);
        result[root] += result[next] + nodeNum[next];
        nodeNum[root] += nodeNum[next];
      }
    }
  }

  private void preOrder(int root, int parent, int n) {
    for (int next : graph[root]) {
      if (next != parent) {
        result[next] = result[root] - 2 * nodeNum[next] + n;
        preOrder(next, root, n);
      }
    }
  }

}