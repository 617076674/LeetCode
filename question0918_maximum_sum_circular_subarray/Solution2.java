package question0918_maximum_sum_circular_subarray;

import java.util.LinkedList;

public class Solution2 {

  public int maxSubarraySumCircular(int[] A) {
    int[] sums = new int[A.length * 2];
    sums[0] = A[0];
    for (int i = 1; i < sums.length; i++) {
      sums[i] = sums[i - 1] + A[i % A.length];
    }
    LinkedList<Integer> linkedList = new LinkedList<>();
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < sums.length; i++) {
      while (!linkedList.isEmpty() && i - linkedList.peekFirst() > A.length) {
        linkedList.pollFirst();
      }
      result = Math.max(result, sums[i] - (linkedList.isEmpty() ? 0 : sums[linkedList.peekFirst()]));
      while (!linkedList.isEmpty() && sums[linkedList.peekLast()] >= sums[i]) {
        linkedList.pollLast();
      }
      linkedList.addLast(i);
    }
    return result;
  }

}
