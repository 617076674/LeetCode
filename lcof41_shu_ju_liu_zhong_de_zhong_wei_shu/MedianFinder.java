package lcof41_shu_ju_liu_zhong_de_zhong_wei_shu;

import java.util.PriorityQueue;

public class MedianFinder {

  private PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // 最小堆

  private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((num1, num2) -> num2 - num1); // 最大堆

  /**
   * initialize your data structure here.
   */
  public MedianFinder() {

  }

  public void addNum(int num) {
    if (maxHeap.isEmpty()) {
      maxHeap.add(num);
      return;
    }
    if (minHeap.size() == maxHeap.size()) {
      if (num <= minHeap.peek()) {
        maxHeap.add(num);
        return;
      }
      maxHeap.add(minHeap.poll());
      minHeap.add(num);
      return;
    }
    if (num <= maxHeap.peek()) {
      minHeap.add(maxHeap.poll());
      maxHeap.add(num);
      return;
    }
    minHeap.add(num);
  }

  public double findMedian() {
    if (((minHeap.size() + maxHeap.size()) & 1) == 1) {
      return maxHeap.peek();
    }
    return 0.5 * (minHeap.peek() + maxHeap.peek());
  }

}