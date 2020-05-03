package question0700_search_in_a_binary_search_tree;

/**
 * 递归。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：1ms，击败84.78%。消耗内存：50MB，击败29.26%。
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root || val == root.val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}