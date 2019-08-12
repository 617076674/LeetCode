package question0235;

/**
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度均是O(h)，其中h为树的高度。
 *
 * 执行用时：10ms，击败87.38%。消耗内存：41.4MB，击败5.03%。
 */
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val <= root.val && q.val >= root.val) {
            return root;
        } else if (p.val >= root.val && q.val <= root.val) {
            return root;
        } else if (p.val <= root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
}