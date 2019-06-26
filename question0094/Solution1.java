package question0094;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h为二叉树的高度。
 *
 * 执行用时：1ms，击败99.01%。消耗内存：35.1MB，击败39.36%。
 */
public class Solution1 {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }

    private void inorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inorder(treeNode.left);
        list.add(treeNode.val);
        inorder(treeNode.right);
    }
}
