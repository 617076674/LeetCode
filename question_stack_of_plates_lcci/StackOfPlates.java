package question_stack_of_plates_lcci;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackOfPlates {
    private List<Stack<Integer>> stackList;

    private int cap;

    public StackOfPlates(int cap) {
        stackList = new ArrayList<>();
        this.cap = cap;
    }
    
    public void push(int val) {
        if (cap <= 0) {
            return;
        }
        if (stackList.size() == 0) {
            stackList.add(singletonStack(val));
        } else {
            if (stackList.get(stackList.size() - 1).size() == cap) {
                stackList.add(singletonStack(val));
            } else {
                stackList.get(stackList.size() - 1).push(val);
            }
        }
    }

    private Stack<Integer> singletonStack(int num) {
        Stack<Integer> stack = new Stack<>();
        stack.push(num);
        return stack;
    }
    
    public int pop() {
        return popAt(stackList.size() - 1);
    }

    public int popAt(int index) {
        if (index >= stackList.size() || index < 0 || stackList.get(index).isEmpty()) {
            return -1;
        }
        Stack<Integer> stack = stackList.get(index);
        int result = stack.pop();
        if (stack.isEmpty()) {
            stackList.remove(index);
        }
        return result;
    }
}