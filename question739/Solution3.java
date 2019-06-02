package question739;

import java.util.LinkedList;

public class Solution3 {

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

}
