package question0703_kth_largest_element_in_a_stream;

import java.util.PriorityQueue;

/**
 * 优先队列。
 *
 * 执行用时：89ms，击败86.62%。消耗内存：47.8MB，击败93.52%。
 */
public class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();

    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else {
                if (pq.peek() < num) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } else {
            if (val > pq.peek()) {
                pq.poll();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}