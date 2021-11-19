package question2045_second_minimum_time_to_reach_destination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public int secondMinimum(int n, int[][] edges, int time, int change) {
    List<Integer>[] graph = new List[n + 1];
    for (int[] edge : edges) {
      int node1 = edge[0], node2 = edge[1];
      if (null == graph[node1]) {
        graph[node1] = new ArrayList<>();
      }
      graph[node1].add(node2);
      if (null == graph[node2]) {
        graph[node2] = new ArrayList<>();
      }
      graph[node2].add(node1);
    }
    int[] visited = new int[n + 1];
    int[] distance = new int[n + 1];
    Arrays.fill(distance, -1);
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {1, 0});
    distance[1] = 0;
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int round = cur[1] / change;
      int nextTime;
      if (round % 2 == 0) {
        nextTime = cur[1] + time;
      } else {
        nextTime = (round + 1) * change + time;
      }
      for (int next : graph[cur[0]]) {
        if (visited[next] < 2 && distance[next] < nextTime) {
          distance[next] = nextTime;
          visited[next]++;
          queue.add(new int[] {next, nextTime});
          if (visited[next] == 2 && next == n) {
            return nextTime;
          }
        }
      }
    }
    return -1;
  }

}