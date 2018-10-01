package question071;

import java.util.Stack;

public class Solution {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");
        for (int i = 0; i < strings.length; i++) {
            if (".".equals(strings[i])) {
                continue;
            } else if ("..".equals(strings[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!"".equals(strings[i])) {
                stack.push(strings[i]);
            }
        }
        String result = "";
        while(!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        return result.equals("") ? "/" : result;
    }
}
