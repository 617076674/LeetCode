package question0598;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author qianyihui
 * @date 2019-07-26
 *
 * 非递归实现。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：8ms，击败28.12%。消耗内存：53.1MB，击败72.81%。
 */
public class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
        return result;
    }
}
