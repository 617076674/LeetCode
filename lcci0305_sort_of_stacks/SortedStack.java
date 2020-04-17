package lcci0305_sort_of_stacks;

import java.util.LinkedList;

/**
 * 执行用时：107ms，击败69.00%。消耗内存：41MB，击败100.00%
 */
public class SortedStack {
    private LinkedList<Integer> stack1, stack2;

    public SortedStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    
    public void push(int val) {
        if (stack1.isEmpty() || val <= stack1.peek()) {
            stack1.push(val);
        } else {
            while (!stack1.isEmpty() && val > stack1.peek()) {
                stack2.push(stack1.pop());
            }
            stack1.push(val);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }
    
    public void pop() {
        if (!stack1.isEmpty()) {
            stack1.pop();
        }
    }
    
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack1.peek();
    }
    
    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}