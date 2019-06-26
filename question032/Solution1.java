package question032;

import java.util.Stack;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82555851
 */
public class Solution1 {

    public int longestValidParentheses(String s) {
        int result = 0;
        int begin = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    begin = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        result = Math.max(result, i - begin + 1);
                    } else {
                        result = Math.max(result, i - stack.peek());
                    }
                }
            }
        }
        return result;
    }
}
