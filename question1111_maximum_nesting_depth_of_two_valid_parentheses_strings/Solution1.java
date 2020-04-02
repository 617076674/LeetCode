package question1111_maximum_nesting_depth_of_two_valid_parentheses_strings;

import java.util.Stack;

/**
 * 首先，计算出每一个'('或')'的嵌套深度。再根据嵌套深度的奇偶性将其分成A、B两个子序列。
 */
public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n;
        if (null == seq || (n = seq.length()) == 0) {
            return new int[0];
        }
        Stack<Character> stack = new Stack<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                stack.push(c);
                result[i] = stack.size();
            } else {
                result[i] = stack.size();
                stack.pop();
            }
        }
        for (int i = 0; i < n; i++) {
            if ((result[i] & 1) == 1) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
}