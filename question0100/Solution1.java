package question0100;

/**
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：1ms，击败84.34%。消耗内存35.3MB，击败53.89%。
 */
public class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
