package lcci0302_min_stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack-lcci/
 *
 * 执行用时：19ms，击败77.11%。消耗内存：41.7MB，击败100.00%。
 */
public class MinStack {
    private Stack<Integer> stack1, stack2;

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(x);
        } else {
            stack2.push(Math.min(x, stack2.peek()));
        }
    }
    
    public void pop() {
        stack1.pop();
        stack2.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}