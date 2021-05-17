package question1462_course_schedule_iv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
    boolean[][] graph = new boolean[n][n];
    int[] inDegree = new int[n];
    for (int[] prerequisity : prerequisites) {
      graph[prerequisity[0]][prerequisity[1]] = true;
      inDegree[prerequisity[1]]++;
    }
    Set<Integer>[] parentSet = new Set[n];
    for (int i = 0; i < n; i++) {
      parentSet[i] = new HashSet<>();
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int i = 0; i < n; i++) {
        if (graph[cur][i]) {
          inDegree[i]--;
          if (inDegree[i] == 0) {
            queue.add(i);
          }
          parentSet[i].addAll(parentSet[cur]);
          parentSet[i].add(cur);
        }
      }
    }
    List<Boolean> result = new ArrayList<>();
    for (int i = 0; i < queries.length; i++) {
      result.add(parentSet[queries[i][1]].contains(queries[i][0]));
    }
    return result;
  }

}