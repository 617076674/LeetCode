package question1782;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int[] countPairs(int n, int[][] edges, int[] queries) {
    int[] node2Edges = new int[n];
    Map<Integer, Integer> edge2Count = new HashMap<>();
    for (int[] edge : edges) {
      int node1 = edge[0] - 1, node2 = edge[1] - 1;
      node2Edges[node1]++;
      node2Edges[node2]++;
      int key = getKey(node1, node2, n);
      edge2Count.put(key, edge2Count.getOrDefault(key, 0) + 1);
    }
    int[] sortedNodes = new int[n];
    System.arraycopy(node2Edges, 0, sortedNodes, 0, n);
    Arrays.sort(sortedNodes);
    int index = 0;
    int[] result = new int[queries.length];
    for (int query : queries) {
      int right = n - 1;
      for (int left = 0; left < n; left++) {
        if (left >= right) {
          result[index] += n - 1 - left;
        } else {
          while (right > left && sortedNodes[left] + sortedNodes[right] > query) {
            right--;
          }
          result[index] += n - right - 1;
        }
      }
      for (int key : edge2Count.keySet()) {
        int node1 = key / n, node2 = key % n;
        if (node2Edges[node1] + node2Edges[node2] > query && node2Edges[node1] + node2Edges[node2] - edge2Count.get(key) <= query) {
          result[index]--;
        }
      }
      index++;
    }
    return result;
  }

  private static int getKey(int node1, int node2, int n) {
    int min = Math.min(node1, node2), max = Math.max(node1, node2);
    return min * n + max;
  }

}