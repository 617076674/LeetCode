package question2050_parallel_courses_iii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public int minimumTime(int n, int[][] relations, int[] time) {
    int[] inDegree = new int[n];
    List<Integer>[] graph = new List[n];
    for (int[] relation : relations) {
      int prev = relation[0] - 1, next = relation[1] - 1;
      inDegree[next]++;
      if (null == graph[prev]) {
        graph[prev] = new ArrayList<>();
      }
      graph[prev].add(next);
    }
    int[] minMonth = new int[n];
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      minMonth[cur] += time[cur];
      if (null != graph[cur]) {
        for (int next : graph[cur]) {
          inDegree[next]--;
          if (inDegree[next] == 0) {
            queue.add(next);
          }
          minMonth[next] = Math.max(minMonth[next], minMonth[cur]);
        }
      }
    }
    int result = 0;
    for (int min : minMonth) {
      result = Math.max(result, min);
    }
    return result;
  }

}