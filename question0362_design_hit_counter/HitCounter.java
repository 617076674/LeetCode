package question0362_design_hit_counter;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：34.3MB，击败64.10%。
 */
public class HitCounter {
    private Deque<Integer> deque;

    /** Initialize your data structure here. */
    public HitCounter() {
        deque = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        deque.addLast(timestamp);
        while (!deque.isEmpty() && deque.getFirst() < timestamp - 300) {
            deque.removeFirst();
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!deque.isEmpty() && deque.getFirst() < timestamp - 300) {
            deque.removeFirst();
        }
        return deque.size();
    }
}