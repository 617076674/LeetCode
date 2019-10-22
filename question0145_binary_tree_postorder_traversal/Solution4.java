package question0145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 双栈实现。
 *
 * 考虑前序遍历question144中的Solution3解法，前序遍历的顺序是：当前节点->左子树->右子树，而后序遍历的顺序是：左子树->右子树->当前节点。
 *
 * 因此只需用另一个栈来倒转前序遍历的结果即可。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h为二叉树的高度。
 *
 * 执行用时：2ms，击败61.06%。消耗内存：34.7MB，击败37.21%。
 */
public class Solution4 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode treeNode = stack1.pop();
            stack2.push(treeNode.val);
            if (null != treeNode.left) {
                stack1.push(treeNode.left);
            }
            if (null != treeNode.right) {
                stack1.push(treeNode.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop());
        }
        return list;
    }
}

