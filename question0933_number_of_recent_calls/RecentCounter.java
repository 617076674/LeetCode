package question0933_number_of_recent_calls;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列。
 *
 * 执行用时：123ms，击败72.04%。消耗内存：66MB，击败69.95%。
 */
public class RecentCounter {
    Deque<Integer> deque;

    public RecentCounter() {
        deque = new LinkedList<>();
    }
    
    public int ping(int t) {
        deque.add(t);
        while (!deque.isEmpty() && deque.getFirst() < t - 3000) {
            deque.removeFirst();
        }
        return deque.size();
    }
}