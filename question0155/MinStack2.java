package question0155;

import java.util.LinkedList;

/**
 * 双栈实现。一个栈根据入栈和出栈的顺序保存原来入栈的值。另一个栈的栈顶则保存当前栈的最小值。
 *
 * push() top() pop() 和getMin()函数的时间复杂度都是O(1)。
 *
 * 执行用时：71ms，击败99.55%。消耗内存：40.3MB，击败95.44%。
 */
public class MinStack2 {
    private LinkedList<Integer> stack;

    private LinkedList<Integer> auxStack;

    public MinStack2() {
        stack = new LinkedList<>();
        auxStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (auxStack.isEmpty()) {
            auxStack.push(x);
        } else {
            auxStack.push(Math.min(x, auxStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        auxStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return auxStack.peek();
    }
}
