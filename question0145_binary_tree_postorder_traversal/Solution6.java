package question0145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author qianyihui
 * @date 2019-07-12
 *
 * 新增一个指针pre，记录前一个访问的节点。与Solution6相比，减少了许多不必要的入栈和出栈操作。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h为二叉树的高度。
 *
 * 执行用时：2ms，击败62.27%。消耗内存：34.8MB，击败37.05%。
 */
public class Solution6 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if ((null == cur.left && null == cur.right) || (null != cur.right && pre == cur.right) || (null == cur.right && pre == cur.left)) {
                result.add(cur.val);
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return result;
    }
}