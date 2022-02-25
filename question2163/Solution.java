package question2163;

import java.util.PriorityQueue;

public class Solution {

  public long minimumDifference(int[] nums) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    int n = nums.length / 3;
    long[] sumsLeft = new long[nums.length];
    for (int i = 0; i < n; i++) {
      maxHeap.add(nums[i]);
      sumsLeft[n - 1] += nums[i];
    }
    for (int i = n; i < 2 * n; i++) {
      sumsLeft[i] = sumsLeft[i - 1] + nums[i];
      maxHeap.add(nums[i]);
      sumsLeft[i] -= maxHeap.poll();
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    long[] sumsRight = new long[nums.length];
    for (int i = 3 * n - 1; i >= 2 * n; i--) {
      minHeap.add(nums[i]);
      sumsRight[2 * n] += nums[i];
    }
    for (int i = 2 * n - 1; i >= n; i--) {
      sumsRight[i] = sumsRight[i + 1] + nums[i];
      minHeap.add(nums[i]);
      sumsRight[i] -= minHeap.poll();
    }
    long result = Long.MAX_VALUE;
    for (int i = n - 1; i < 2 * n; i++) {
      // [0, i] 属于左半边，[i + 1, 3 * n - 1] 属于右半边
      result = Math.min(result, sumsLeft[i] - sumsRight[i + 1]);
    }
    return result;
  }

}