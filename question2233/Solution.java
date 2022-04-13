package question2233;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public int maximumProduct(int[] nums, int k) {
    Queue<Integer> queue = new PriorityQueue<>();
    for (int num : nums) {
      queue.add(num);
    }
    while (k > 0) {
      int top = queue.poll();
      k--;
      queue.add(top + 1);
    }
    long res = 1;
    while (!queue.isEmpty()) {
      res *= queue.poll();
      res %= 1000000007;
    }
    return (int) res;
  }

}
