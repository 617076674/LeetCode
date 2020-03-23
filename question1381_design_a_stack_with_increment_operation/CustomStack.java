package question1381_design_a_stack_with_increment_operation;

public class CustomStack {
    private int[] stack;

    private int index;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
    }
    
    public void push(int x) {
        if (index < stack.length) {
            stack[index++] = x;
        }
    }
    
    public int pop() {
        if (index == 0) {
            return -1;
        }
        return stack[--index];
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, index); i++) {
            stack[i] += val;
        }
    }
}