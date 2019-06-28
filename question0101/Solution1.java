package question0101;

/**
 * 将原树的左子树与翻转后的右子树相比，如果相同，则是对称二叉树。否则，不是对称二叉树。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h是二叉树的高度。
 *
 * 执行用时：2ms，击败85.03%。消耗内存：36.1MB，击败79.25%。
 */
public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSameTree(root.left, inverseTree(root.right));
    }

    private TreeNode inverseTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = inverseTree(root.right);
        root.right = inverseTree(tmp);
        return root;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
