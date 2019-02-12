package question225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	private Queue<Integer> queue1;
	private Queue<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(queue1.size() != 1) {
        	queue2.add(queue1.poll());
        }
        int result = queue1.poll();
        while(!queue2.isEmpty()) {
        	queue1.add(queue2.poll());
        }
        return result;
    }
    /** Get the top element. */
    public int top() {
    	while(queue1.size() != 1) {
        	queue2.add(queue1.poll());
        }
        int result = queue1.poll();
        while(!queue2.isEmpty()) {
        	queue1.add(queue2.poll());
        }
        queue1.add(result);
        return result;
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
