package lcof09_yong_liang_ge_zhan_shi_xian_dui_lie;

import java.util.LinkedList;

/**
 * 执行用时：58ms，击败64.76%。消耗内存：48.8MB，击败100.00%。
 */
public class CQueue {
    private LinkedList<Integer> stack1, stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.pop();
    }
}