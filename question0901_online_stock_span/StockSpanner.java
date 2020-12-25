package question0901_online_stock_span;

import java.util.LinkedList;

public class StockSpanner {

    private LinkedList<Integer> stack = new LinkedList<>();

    private int[] nums = new int[10001];

    int index;

    public StockSpanner() {

    }
    
    public int next(int price) {
        while (!stack.isEmpty() && price >= nums[stack.peek()]) {
            stack.pop();
        }
        int result = stack.isEmpty() ? index + 1 : index - stack.peek();
        stack.push(index);
        nums[index++] = price;
        return result;
    }

}