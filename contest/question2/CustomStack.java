package contest.question2;

import java.util.Stack;

public class CustomStack {
    private Stack<Integer> stack = new Stack<>();

    private int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if (stack.size() < maxSize) {
            stack.push(x);
        }
    }
    
    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.pop();
    }
    
    public void increment(int k, int val) {
        Stack<Integer> tmp = new Stack<>();
        while (!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        while (!tmp.isEmpty()) {
            if (k-- > 0) {
                stack.push(tmp.pop() + val);
            } else {
                stack.push(tmp.pop());
            }
        }
    }
}