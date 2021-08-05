package question0786_k_th_smallest_prime_fraction;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {

  public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    Queue<int[]> queue =
        new PriorityQueue<>((pair1, pair2) -> pair2[0] * pair1[1] - pair1[0] * pair2[1]);
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        queue.add(new int[] {arr[i], arr[j]});
        if (queue.size() > k) {
          queue.poll();
        }
      }
    }
    return queue.peek();
  }

}