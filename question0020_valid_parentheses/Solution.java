package question0020_valid_parentheses;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * 栈的应用。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串s的长度。
 *
 * 执行用时：2ms，击败95.37%。消耗内存：34.1MB，击败87.62%。
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}