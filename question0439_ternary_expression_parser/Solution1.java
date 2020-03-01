package question0439_ternary_expression_parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 从左向右扫描，递归实现。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为字符串expression的长度。
 *
 * 执行用时：10ms，击败53.85%。消耗内存：41.2MB，击败7.84%。
 */
public class Solution1 {
    private Map<Integer, Integer> map = new HashMap<>();    //键是每一个?的索引，值是该?对应的:的索引

    public String parseTernary(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '?') {
                stack.push(i);
            } else if (c == ':') {
                map.put(stack.pop(), i);
            }
        }
        return parseTernary(expression, 0, expression.length() - 1);
    }

    private String parseTernary(String expression, int left, int right) {
        if (right == left) {
            return expression.substring(left, right + 1);
        }
        if (expression.charAt(left) == 'T') {
            return parseTernary(expression, left + 2, map.get(left + 1) - 1);
        }
        return parseTernary(expression, map.get(left + 1) + 1, right);
    }
}