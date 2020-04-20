package lcci0408_first_common_ancestor;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || p == root || q == root) {
            return root;
        }
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q),
                rightResult = lowestCommonAncestor(root.right, p, q);
        if (null == leftResult) {
            return rightResult;
        }
        if (null == rightResult) {
            return leftResult;
        }
        return root;
    }
}