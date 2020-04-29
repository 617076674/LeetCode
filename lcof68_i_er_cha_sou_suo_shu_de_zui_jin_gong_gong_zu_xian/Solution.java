package lcof68_i_er_cha_sou_suo_shu_de_zui_jin_gong_gong_zu_xian;

/**
 * 执行用时：7ms，击败55.09%。消耗内存：41.4MB，击败100.00%。
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val), max = Math.max(p.val, q.val);
        if (root.val >= min && root.val <= max) {
            return root;
        } else if (root.val < min) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return lowestCommonAncestor(root.left, p, q);
    }
}