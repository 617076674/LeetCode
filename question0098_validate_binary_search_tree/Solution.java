package question0098_validate_binary_search_tree;

/**
 * 中序遍历，判断中序遍历序列是否是递增的。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败44.13%。消耗内存：37.1MB，击败86.52%。
 */
public class Solution {
    private Integer pre;

    private boolean result = true;

    public boolean isValidBST(TreeNode root) {
        inorderTraversal(root);
        return result;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null || !result) {
            return;
        }
        inorderTraversal(root.left);
        if (pre != null && root.val <= pre) {
            result = false;
        }
        pre = root.val;
        inorderTraversal(root.right);
    }
}