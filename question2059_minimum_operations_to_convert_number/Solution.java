package question2059_minimum_operations_to_convert_number;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public int minimumOperations(int[] nums, int start, int goal) {
    if (start == goal) {
      return 0;
    }
    boolean[] visited = new boolean[1001];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;
    int step = 1;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      for (int i = 0; i < qSize; i++) {
        int cur = queue.poll();
        for (int num : nums) {
          int next = cur - num;
          if (next == goal) {
            return step;
          }
          if (next >= 0 && next <= 1000 && !visited[next]) {
            visited[next] = true;
            queue.add(next);
          }
          next = cur + num;
          if (next == goal) {
            return step;
          }
          if (next >= 0 && next <= 1000 && !visited[next]) {
            visited[next] = true;
            queue.add(next);
          }
          next = cur ^ num;
          if (next == goal) {
            return step;
          }
          if (next >= 0 && next <= 1000 && !visited[next]) {
            visited[next] = true;
            queue.add(next);
          }
        }
      }
      step++;
    }
    return -1;
  }

}