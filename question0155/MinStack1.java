package question0155;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 用一个list来保存栈中所有元素，每次进行弹出栈操作时都需要遍历这个list来寻找最小值。
 *
 * push() top() 和getMin()函数的时间复杂度都是O(1)。pop()函数的时间复杂度是O(n)，其中n为栈中的元素个数。
 *
 * 执行用时：75ms，击败98.53%。消耗内存：40.1MB，击败95.63%。
 */
public class MinStack1 {
    private LinkedList<Integer> stack;
    List<Integer> array;
    int min;

    public MinStack1() {
        stack = new LinkedList<>();
        array = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        array.add(x);
        min = Math.min(min, x);
    }

    public void pop() {
        int num = stack.pop();
        array.remove(array.size() - 1);
        if (array.size() > 0) {
            min = array.get(0);
            for (int i = 0; i < array.size(); i++) {
                if (min > array.get(i)) {
                    min = array.get(i);
                }
            }
        } else {
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
