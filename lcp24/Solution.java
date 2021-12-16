package lcp24;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  private static final int MOD = 1000000007;

  public int[] numsGame(int[] nums) {
    if (nums.length == 1) {
      return new int[] {0};
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] -= i;
    }
    // 存储较小部分元素的大顶堆，minQueue.size() 可能比 maxQueue.size() 大 1
    Queue<Integer> minQueue = new PriorityQueue<>((a, b) -> b - a);
    // 存储较大部分元素的小顶堆
    Queue<Integer> maxQueue = new PriorityQueue<>();
    long minSum = 0, maxSum = 0;
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (minQueue.size() == maxQueue.size()) {
        if (!maxQueue.isEmpty() && nums[i] > maxQueue.peek()) {
          int temp = maxQueue.poll();
          maxSum -= temp;
          minQueue.add(temp);
          minSum += temp;
          maxQueue.add(nums[i]);
          maxSum += nums[i];
        } else {
          minQueue.add(nums[i]);
          minSum += nums[i];
        }
      } else if (minQueue.size() == maxQueue.size() + 1) {
        if (nums[i] >= minQueue.peek()) {
          maxQueue.add(nums[i]);
          maxSum += nums[i];
        } else {
          minQueue.add(nums[i]);
          minSum += nums[i];
          int temp = minQueue.poll();
          minSum -= temp;
          maxQueue.add(temp);
          maxSum += temp;
        }
      }
      if ((i & 1) == 0) {
        // 奇数个数
        result[i] = (int) ((maxSum - minSum + minQueue.peek()) % MOD);
      } else {
        result[i] = (int) ((maxSum - minSum) % MOD);
      }
    }
    return result;
  }

}