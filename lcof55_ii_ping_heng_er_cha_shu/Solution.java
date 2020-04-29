package lcof55_ii_ping_heng_er_cha_shu;

/**
 * 执行用时：1ms，击败99.95%。消耗内存：40MB，击败100.00%。
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode treeNode) {
        if (null == treeNode) {
            return 0;
        }
        return Math.max(getHeight(treeNode.left), getHeight(treeNode.right)) + 1;
    }
}