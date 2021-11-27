package question1675_minimize_deviation_in_array;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public int minimumDeviation(int[] nums) {
    int min = Integer.MAX_VALUE;
    Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int num : nums) {
      if ((num & 1) == 1) {
        num = num << 1;
      }
      queue.offer(num);
      min = Math.min(min, num);
    }
    int result = queue.peek() - min;
    while (!queue.isEmpty() && (queue.peek() & 1) == 0) {
      int temp = queue.peek() >> 1;
      queue.poll();
      queue.offer(temp);
      min = Math.min(min, temp);
      result = Math.min(result, queue.peek() - min);
    }
    return result;
  }

}