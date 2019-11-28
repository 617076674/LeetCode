package question0716_max_stack;

import java.util.Stack;

/**
 * 双栈实现。
 *
 * 执行用时：84ms，击败54.67%。消耗内存：58.8MB，击败100.00%。
 */
public class MaxStack1 {
    private Stack<Integer> stack1, stack2;

    /** initialize your data structure here. */
    public MaxStack1() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(x);
        } else {
            stack2.push(Math.max(x, stack2.peek()));
        }
    }
    
    public int pop() {
        stack2.pop();
        return stack1.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int peekMax() {
        return stack2.peek();
    }
    
    public int popMax() {
        Stack<Integer> stack = new Stack<>();
        while (!stack1.peek().equals(stack2.peek())) {
            stack.push(stack1.pop());
            stack2.pop();
        }
        int result = stack1.pop();
        stack2.pop();
        while (!stack.isEmpty()) {
            this.push(stack.pop());
        }
        return result;
    }
}