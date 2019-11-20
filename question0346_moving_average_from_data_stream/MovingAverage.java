package question0346_moving_average_from_data_stream;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/moving-average-from-data-stream/
 *
 * 双端队列。
 *
 * 执行用时：33ms，击败98.52%。消耗内存：42.2MB，击败100.00%。
 */
public class MovingAverage {
    private Deque<Integer> deque = new LinkedList<>();

    private int count;

    private int size;

    private int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if (count == size) {
            sum += val - deque.removeFirst();
            deque.addLast(val);
            return sum * 1.0 / count;
        } else {
            sum += val;
            deque.addLast(val);
            count++;
            return sum * 1.0 / count;
        }
    }
}