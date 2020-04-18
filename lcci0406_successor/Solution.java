package lcci0406_successor;

/**
 * 中序遍历。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：3ms，击败100.00%。消耗内存：40.2MB，击败100.00%。
 */
public class Solution {
    private TreeNode pre, result;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrderTraversal(root, p);
        return result;
    }

    private void inOrderTraversal(TreeNode treeNode, TreeNode p) {
        if (null == treeNode || null != result) {
            return;
        }
        inOrderTraversal(treeNode.left, p);
        if (pre == p) {
            result = treeNode;
        }
        pre = treeNode;
        inOrderTraversal(treeNode.right, p);
    }
}