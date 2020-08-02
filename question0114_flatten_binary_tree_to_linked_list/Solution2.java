package question0114_flatten_binary_tree_to_linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历（迭代实现）
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：2ms，击败9.94%。消耗内存：39.6MB，击败41.80%。
 */
public class Solution2 {
    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }
        List<TreeNode> preOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            preOrder.add(treeNode);
            //在访问本节点后先入栈右孩子，再入栈左孩子
            if (null != treeNode.right) {
                stack.push(treeNode.right);
            }
            if (null != treeNode.left) {
                stack.push(treeNode.left);
            }
        }
        TreeNode cur = root;
        for (int i = 0; i < preOrder.size() - 1; i++) {
            cur.left = null;
            cur.right = preOrder.get(i + 1);
            cur = cur.right;
        }
    }
}