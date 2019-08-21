package question0844;

import java.util.Stack;

/**
 * @author qianyihui
 * @date 2019-08-21
 *
 * 用栈。
 *
 * 时间复杂度和空间复杂度均是O(max(n1, n2))，其中n1为字符串S的长度，n2为字符串T的长度。
 *
 * 执行用时：7ms，击败26.55%。消耗内存：35MB，击败77.78%。
 */
public class Solution1 {
    public boolean backspaceCompare(String S, String T) {
        return transform(S).equals(transform(T));
    }

    private String transform(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
