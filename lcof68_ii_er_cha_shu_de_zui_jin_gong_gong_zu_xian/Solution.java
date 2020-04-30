package lcof68_ii_er_cha_shu_de_zui_jin_gong_gong_zu_xian;

/**
 * 执行用时：7ms，击败100.00%。消耗内存：41.9MB，击败100.00%。
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || p == root || q == root) {
            return root;
        }
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q), rightResult = lowestCommonAncestor(root.right, p, q);
        if (null != leftResult && null != rightResult) {
            return root;
        }
        if (null == leftResult) {
            return rightResult;
        }
        return leftResult;
    }
}