package question0114_flatten_binary_tree_to_linked_list;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历（递归实现）
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：1ms，击败33.60%。消耗内存：39.6MB，击败47.54%。
 */
public class Solution1 {
    private List<TreeNode> preOrder = new ArrayList<>();

    public void flatten(TreeNode root) {
        preOrderTraversal(root);
        TreeNode cur = root;
        for (int i = 0; i < preOrder.size() - 1; i++) {
            cur.left = null;
            cur.right = preOrder.get(i + 1);
            cur = cur.right;
        }
    }

    private void preOrderTraversal(TreeNode root) {
        if (null == root) {
            return;
        }
        preOrder.add(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}