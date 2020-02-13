package question0071_simplify_path;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/simplify-path/
 *
 * 栈的应用。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为路径path的长度。
 *
 * 执行用时：8ms，击败31.38%。消耗内存：43.5MB，击败5.04%。
 */
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
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop()).insert(0, "/");
        }
        return result.toString().equals("") ? "/" : result.toString();
    }
}