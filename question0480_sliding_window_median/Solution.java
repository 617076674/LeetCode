package question0480_sliding_window_median;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

  private static class DualHeap {

    private PriorityQueue<Integer> small;   // 大根堆，维护较小的一半元素

    private PriorityQueue<Integer> large;   // 小根堆，维护较大的一半元素

    private Map<Integer, Integer> delayed;  // 哈希表，记录「延迟删除」的元素，key 为元素，value 为需要删除的次数

    private boolean isOdd;

    // small 和 large 当前包含的元素个数，需要扣除被「延迟删除」的元素
    private int smallSize;

    private int largeSize;

    public DualHeap(int k) {
      this.small = new PriorityQueue<>(Comparator.reverseOrder());
      this.large = new PriorityQueue<>(Comparator.naturalOrder());
      this.delayed = new HashMap<>();
      this.isOdd = (k & 1) == 1;
    }

    public double getMedian() {
      return isOdd ? small.peek() : ((double) small.peek() + large.peek()) / 2;
    }

    public void insert(int num) {
      if (small.isEmpty() || num <= small.peek()) {
        small.offer(num);
        smallSize++;
      } else {
        large.offer(num);
        largeSize++;
      }
      makeBalance();
    }

    public void erase(int num) {
      delayed.put(num, delayed.getOrDefault(num, 0) + 1);
      if (num <= small.peek()) {
        smallSize--;
        if (num == small.peek()) {
          prune(small);
        }
      } else {
        largeSize--;
        if (num == large.peek()) {
          prune(large);
        }
      }
      makeBalance();
    }

    // 不断地弹出 heap 的堆顶元素，并且更新哈希表
    private void prune(PriorityQueue<Integer> heap) {
      while (!heap.isEmpty()) {
        int num = heap.peek();
        if (delayed.containsKey(num)) {
          delayed.put(num, delayed.get(num) - 1);
          if (delayed.get(num) == 0) {
            delayed.remove(num);
          }
          heap.poll();
        } else {
          break;
        }
      }
    }

    // 调整 small 和 large 中的元素个数，使得二者的元素个数满足要求
    private void makeBalance() {
      if (smallSize > largeSize + 1) {
        // small 比 large 元素多 2 个
        large.offer(small.poll());
        smallSize--;
        largeSize++;
        // small 堆顶元素被移除，需要进行 prune
        prune(small);
      } else if (smallSize < largeSize) {
        // large 比 small 元素多 1 个
        small.offer(large.poll());
        smallSize++;
        largeSize--;
        // large 堆顶元素被移除，需要进行 prune
        prune(large);
      }
    }

  }

  public double[] medianSlidingWindow(int[] nums, int k) {
    DualHeap dualHeap = new DualHeap(k);
    for (int i = 0; i < k; i++) {
      dualHeap.insert(nums[i]);
    }
    double[] result = new double[nums.length - k + 1];
    result[0] = dualHeap.getMedian();
    for (int i = k; i < nums.length; i++) {
      dualHeap.insert(nums[i]);
      dualHeap.erase(nums[i - k]);
      result[i - k + 1] = dualHeap.getMedian();
    }
    return result;
  }

}