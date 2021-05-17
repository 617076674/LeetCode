package question1642_furthest_building_you_can_reach;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {

  public int furthestBuilding(int[] heights, int bricks, int ladders) {
    int n = heights.length, sum = 0;
    Queue<Integer> queue = new PriorityQueue<>();
    for (int i = 1; i < heights.length; i++) {
      int diff = heights[i] - heights[i - 1];
      if (diff > 0) {
        queue.offer(diff);
        if (queue.size() > ladders) {
          sum += queue.poll();
        }
        if (sum > bricks) {
          return i - 1;
        }
      }
    }
    return n - 1;
  }

}