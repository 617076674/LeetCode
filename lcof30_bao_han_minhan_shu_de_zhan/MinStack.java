package lcof30_bao_han_minhan_shu_de_zhan;

import java.util.LinkedList;

public class MinStack {

    private LinkedList<Integer> stack = new LinkedList<>();

    private LinkedList<Integer> helper = new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        stack.push(x);
        if (helper.isEmpty()) {
            helper.push(x);
        } else {
            helper.push(Math.min(x, helper.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        helper.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return helper.peek();
    }

}