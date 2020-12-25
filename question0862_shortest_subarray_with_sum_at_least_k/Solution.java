package question0862_shortest_subarray_with_sum_at_least_k;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

  public int shortestSubarray(int[] A, int K) {
    int[] sums = new int[A.length + 1];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + A[i - 1];
    }
    Deque<Integer> deque = new LinkedList<>();
    int result = -1;
    for (int i = 0; i < sums.length; i++) {
      while (!deque.isEmpty() && sums[i] <= sums[deque.peekLast()]) {
        deque.removeLast();
      }
      while (!deque.isEmpty() && sums[deque.peekFirst()] + K <= sums[i]) {
        if (result == -1) {
          result = i - deque.removeFirst();
        } else {
          result = Math.min(result, i - deque.removeFirst());
        }
      }
      deque.addLast(i);
    }
    return result;
  }

}