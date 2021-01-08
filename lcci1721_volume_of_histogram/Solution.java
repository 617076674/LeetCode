package lcci1721_volume_of_histogram;

import java.util.LinkedList;

public class Solution {

    public int trap(int[] height) {
        int n;
        if (null == height || (n = height.length) <= 2) {
            return 0;
        }
        int result = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                result += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[top]);
            }
            stack.push(i);
        }
        return result;
    }

}