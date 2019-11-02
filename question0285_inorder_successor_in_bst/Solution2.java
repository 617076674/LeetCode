package question0285_inorder_successor_in_bst;

/**
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：3ms，击败100.00%。消耗内存：37.4MB，击败100.00%。
 */
public class Solution2 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == root) {
            //在右子树中寻找最小的节点
            TreeNode next = p.right;
            while (next != null && next.left != null) {
                next = next.left;
            }
            return next;
        } else if (p.val < root.val) {
            TreeNode result = inorderSuccessor(root.left, p);
            //如果左子树中没有找到，那么说明root节点就是p的后继，这一点很重要！
            return result == null ? root : result;
        }
        return inorderSuccessor(root.right, p);
    }
}