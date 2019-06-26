package question232;

import java.util.Stack;

/**
 * 双栈实现队列，原则如下：
 * <p>
 * 添加元素时，始终往stack1中添加。
 * <p>
 * 弹出元素时，如果stack2不为空，则弹出stack2栈顶元素即可。
 * 否则，需要先将stack1中的元素全部弹出并依次压入stack2，再弹出stack2栈顶元素。
 * <p>
 * push()操作的时间复杂度是O(1)。
 * <p>
 * 当stack2为空时，pop()操作的时间复杂度是O(n)，其中n为stack1中的元素数量。
 * 当stack2不为空时，pop()操作的时间复杂度是O(1)。
 * <p>
 * peek()操作的时间复杂度是O(1)。empty()操作的时间复杂度是O(1)。
 * <p>
 * 执行用时：90ms，击败44.57%。消耗内存：33.2MB，击败94.07%。
 */
public class MyQueue {

    private Stack<Integer> stack1;

    private Stack<Integer> stack2;

    private int peekNum;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack1.isEmpty()) {
            peekNum = x;
        }
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        int result = stack2.pop();
        if (!stack2.isEmpty()) {
            peekNum = stack2.peek();
        }
        return result;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return peekNum;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}

