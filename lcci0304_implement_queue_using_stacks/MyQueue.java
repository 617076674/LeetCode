package lcci0304_implement_queue_using_stacks;

import java.util.Stack;

/**
 * 双栈实现队列。
 *
 * 执行用时：12ms，击败88.36%。消耗内存：37.4MB，击败100.00%。
 */
public class MyQueue {
    private Stack<Integer> stack1, stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) {
            while (stack1.size() > 1) {
                stack2.push(stack1.pop());
            }
            return stack1.pop();
        }
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}