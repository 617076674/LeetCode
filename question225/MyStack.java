package question225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 双队列实现栈，原则如下：
 * <p>
 * 添加元素时始终往queue1中添加元素，并更新栈顶元素top值。
 * <p>
 * 弹出元素时，将queue1中的元素除最后一个元素外均添加进queue2中，而queue1中的最后一个元素就是需要弹出的元素。
 * 这个过程中，需要在queue1中还有两个元素时，更新栈顶元素top值。
 * 结束这个过程后，我们需要交换queue1和queue2的引用，以保证queue1始终是一个空队列。
 * <p>
 * push()、top()和empty()操作的时间复杂度均是O(1)。
 * pop()的时间复杂度是O(n)，其中n为栈中已有的元素数量。
 * <p>
 * 执行用时：92ms，击败35.51%。内存消耗：33.2MB，击败97.66%。
 */
public class MyStack {

    private Queue<Integer> queue1;

    private Queue<Integer> queue2;

    private int top;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        //始终往queue1添加元素
        queue1.add(x);
        top = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queue1.size() != 1) {
            if (queue1.size() == 2) {
                top = queue1.peek();
            }
            queue2.add(queue1.poll());
        }
        int result = queue1.poll();
        //交换queue1和queue2，始终保持queue1为空队列
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
