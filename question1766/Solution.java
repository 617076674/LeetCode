package question1766;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

public class Solution {

  private Set<Integer>[] gcdSet = new HashSet[51];

  private Set<Integer>[] graph;

  private int[] result;

  private boolean[] visited;

  public int[] getCoprimes(int[] nums, int[][] edges) {
    for (int i = 1; i <= 50; i++) {
      for (int j = 1; j <= 50; j++) {
        if (gcd(i, j) == 1) {
          if (null == gcdSet[i]) {
            gcdSet[i] = new HashSet<>();
          }
          gcdSet[i].add(j);
          if (null == gcdSet[j]) {
            gcdSet[j] = new HashSet<>();
          }
          gcdSet[j].add(i);
        }
      }
    }
    graph = new HashSet[nums.length];
    for (int[] edge : edges) {
      if (null == graph[edge[0]]) {
        graph[edge[0]] = new HashSet<>();
      }
      graph[edge[0]].add(edge[1]);
      if (null == graph[edge[1]]) {
        graph[edge[1]] = new HashSet<>();
      }
      graph[edge[1]].add(edge[0]);
    }
    visited = new boolean[nums.length];
    result = new int[nums.length];
    int[] recentNode = new int[51];
    Arrays.fill(recentNode, -1);
    visited[0] = true;
    Queue<Pair<Integer, int[]>> queue = new LinkedList<>();
    queue.add(new Pair<>(0, recentNode));
    while (!queue.isEmpty()) {
      Pair<Integer, int[]> pair = queue.poll();
      result[pair.getKey()] = pair.getValue()[nums[pair.getKey()]];
      if (null != graph[pair.getKey()]) {
        for (int next : graph[pair.getKey()]) {
          if (!visited[next]) {
            visited[next] = true;
            int[] copyRecentNode = new int[pair.getValue().length];
            System.arraycopy(pair.getValue(), 0, copyRecentNode, 0, pair.getValue().length);
            if (null != gcdSet[nums[pair.getKey()]]) {
              for (int num : gcdSet[nums[pair.getKey()]]) {
                copyRecentNode[num] = pair.getKey();
              }
            }
            queue.add(new Pair<>(next, copyRecentNode));
          }
        }
      }
    }
    return result;
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}