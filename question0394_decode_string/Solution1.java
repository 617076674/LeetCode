package question0394_decode_string;

import java.util.Stack;

/**
 * 栈的应用。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为字符串 s 的长度。
 *
 * 执行用时：1ms，击败90.12%。消耗内存：37.7MB，击败7.69%。
 */
public class Solution1 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (']' == c) {
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                int times = Integer.parseInt(stack.pop());
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    tmp.append(sb);
                }
                stack.push(tmp.toString());
            } else if (c >= '0' && c <= '9') {
                StringBuilder sb = new StringBuilder();
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    sb.append(s.charAt(i));
                    i++;
                }
                i--;
                stack.push(sb.toString());
            } else {
                stack.push(s.substring(i, i + 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}