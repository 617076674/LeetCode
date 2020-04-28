package lcof28_dui_cheng_de_er_cha_shu;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：38MB，击败100.00%。
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode treeNode1, TreeNode treeNode2) {
        if (null == treeNode1 && null == treeNode2) {
            return true;
        }
        if (null == treeNode1 || null == treeNode2) {
            return false;
        }
        if (treeNode1.val != treeNode2.val) {
            return false;
        }
        return isSymmetric(treeNode1.left, treeNode2.right) && isSymmetric(treeNode1.right, treeNode2.left);
    }
}