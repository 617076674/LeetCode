package question0786_k_th_smallest_prime_fraction;

import java.util.PriorityQueue;

public class Solution3 {

  public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) ->
        arr[pair1[0]] * arr[pair2[1]] - arr[pair1[1]] * arr[pair2[0]]); // 最小堆
    for (int i = 1; i < arr.length; i++) {
      pq.add(new int[] {0, i});
    }
    while (--k > 0) {
      int[] frac = pq.poll();
      if (frac[0]++ < frac[1]) {
        pq.offer(frac);
      }
    }
    int[] ans = pq.poll();
    return new int[] {arr[ans[0]], arr[ans[1]]};
  }

}