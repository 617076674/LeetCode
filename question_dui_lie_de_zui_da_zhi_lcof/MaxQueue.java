package question_dui_lie_de_zui_da_zhi_lcof;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列+双端队列
 *
 * 执行用时：57ms，击败21.43%。消耗内存：46.4MB，击败100.00%。
 */
public class MaxQueue {
    private Queue<Integer> queue;

    private Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
    
    public int max_value() {
        return deque.isEmpty() ? -1 : deque.getFirst();
    }
    
    public void push_back(int value) {
        queue.add(value);
        while (!deque.isEmpty() && deque.getLast() < value) {
            deque.removeLast();
        }
        deque.addLast(value);
    }
    
    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (queue.peek().equals(deque.getFirst())) {
            deque.removeFirst();
        }
        return queue.poll();
    }
}