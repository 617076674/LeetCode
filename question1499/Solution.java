package question1499;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

  public int findMaxValueOfEquation(int[][] points, int k) {
    Deque<Integer> queue = new LinkedList<>();
    int result = Integer.MIN_VALUE;
    int i = 1;
    for (int cur = 0; cur < points.length; cur++) {
      while (!queue.isEmpty() && queue.peekFirst() <= cur) {
        queue.pollFirst();
      }
      i = Math.max(i, cur + 1);
      for (; i < points.length && points[i][0] - points[cur][0] <= k; i++) {
        while (!queue.isEmpty() && points[i][0] + points[i][1] >= points[queue.peekLast()][0] + points[queue.peekLast()][1]) {
          queue.pollLast();
        }
        queue.add(i);
      }
      if (!queue.isEmpty()) {
        result = Math.max(result,
            points[cur][1] - points[cur][0] + points[queue.peekFirst()][0] + points[queue.peekFirst()][1]);
      }
    }
    return result;
  }

}