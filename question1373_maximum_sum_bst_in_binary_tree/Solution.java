package question1373_maximum_sum_bst_in_binary_tree;

/**
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：7ms，击败100.00%。消耗内存：50.4MB，击败100.00%。
 */
public class Solution {
    private int result;

    public int maxSumBST(TreeNode root) {
        preOrderTraversal(root);
        return result;
    }

    private void preOrderTraversal(TreeNode root) {
        if (isBST(root)) {
            sum(root);
            return;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private boolean isBST(TreeNode root) {
        if (null == root || (null == root.left && null == root.right)) {
            return true;
        } else if (null == root.left) {
            if (root.val >= root.right.val) {
                return false;
            }
            return isBST(root.right);
        } else if (null == root.right) {
            if (root.val <= root.left.val) {
                return false;
            }
            return isBST(root.left);
        }
        if (root.val >= root.right.val || root.val <= root.left.val) {
            return false;
        }
        return isBST(root.left) && isBST(root.right);
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + sum(root.left) + sum(root.right);
        result = Math.max(result, sum);
        return sum;
    }
}