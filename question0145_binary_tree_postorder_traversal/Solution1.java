package question0145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h为二叉树的高度。
 *
 * 执行用时：1ms，击败99.18%。消耗内存：34.9MB，击败37.05%。
 */
public class Solution1 {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return list;
    }

    private void postorder(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        postorder(treeNode.left);
        postorder(treeNode.right);
        list.add(treeNode.val);
    }
}