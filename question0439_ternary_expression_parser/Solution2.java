package question0439_ternary_expression_parser;

import java.util.Stack;

/**
 * 从右向左扫描，迭代实现。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串expression的长度。
 *
 * 执行用时：10ms，击败53.85%。消耗内存：38.8MB，击败25.49%。
 */
public class Solution2 {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (c == '?') {
                if (expression.charAt(i - 1) == 'T') {
                    char tmp = stack.pop();
                    stack.pop();
                    stack.push(tmp);
                } else {
                    stack.pop();
                }
                i--;
            } else if (c != ':') {
                stack.push(c);
            }
        }
        return stack.pop().toString();
    }
}