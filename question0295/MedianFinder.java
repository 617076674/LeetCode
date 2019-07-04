package question0295;

import java.util.PriorityQueue;

/**
 * 用最大堆和最小堆存放数据，其中最大堆中存放左半部分较小的数，最小堆中存放右半部分较大的数。
 *
 * addNum()的时间复杂度是O(n)，其中n为数据流中的元素个数。findMedian()的时间复杂度是O(1)。
 *
 * 执行用时：262ms，击败67.73%。消耗内存：69MB，击败43.62%。
 */
public class MedianFinder {

    private PriorityQueue<Integer> minHeap;

    private PriorityQueue<Integer> maxHeap;

    private int count;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        count = 0;
    }
    
    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            if (count == 0) {
                maxHeap.add(num);
            } else {
                if (num > minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }
            }
        } else {
            if (num < maxHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
        count++;
    }
    
    public double findMedian() {
        if ((count & 1) == 1) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) * 0.5;
    }
}
