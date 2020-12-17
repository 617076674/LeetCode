package question0144_binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：1ms，击败99.05%。消耗内存：35.2MB，击败40.72%。
 */
public class Solution1 {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return result;
    }

    private void preorder(TreeNode root) {
        if (null == root) {
            return;
        }
        result.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}