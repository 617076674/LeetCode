package lcci0405_legal_binary_search_tree;

/**
 * 中序遍历。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.4MB，击败100.00%。
 */
public class Solution {
    private Integer pre;

    private boolean result = true;

    public boolean isValidBST(TreeNode root) {
        inOrderTraversal(root);
        return result;
    }

    private void inOrderTraversal(TreeNode treeNode) {
        if (null == treeNode || !result) {
            return;
        }
        inOrderTraversal(treeNode.left);
        if (pre != null && treeNode.val <= pre) {
            result = false;
            return;
        }
        pre = treeNode.val;
        inOrderTraversal(treeNode.right);
    }
}