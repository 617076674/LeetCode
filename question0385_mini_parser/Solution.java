package question0385_mini_parser;

import java.util.Stack;

/**
 * 栈（提交时去掉注释）。
 *
 * 执行用时：13ms，击败38.21%。消耗内存：38.2MB，击败63.94%。
 */
public class Solution {
//    public NestedInteger deserialize(String s) {
//        if (s.charAt(0) != '[') {
//            return new NestedInteger(Integer.parseInt(s));
//        }
//        Stack<NestedInteger> stack = new Stack<>();
//        NestedInteger result = new NestedInteger();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '[') {
//                NestedInteger tmp = new NestedInteger();
//                if (!stack.isEmpty()) {
//                    stack.peek().add(tmp);
//                }
//                stack.push(tmp);
//            } else if ((c >= '0' && c <= '9') || c == '-') {
//                String num = c + "";
//                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
//                    num = num + s.charAt(++i);
//                }
//                NestedInteger tmp = new NestedInteger(Integer.parseInt(num));
//                if (stack.isEmpty()) {
//                    stack.push(tmp);
//                } else {
//                    stack.peek().add(tmp);
//                }
//            } else if (c == ']'){
//                result = stack.pop();
//            }
//        }
//        return result;
//    }
}