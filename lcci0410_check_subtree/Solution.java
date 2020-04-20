package lcci0410_check_subtree;

/**
 * 执行用时：1ms，击败97.13%。消耗内存：42.1MB，击败100.00%。
 */
public class Solution {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (null == t1 && null != t2) {
            return false;
        }
        if (isSameTree(t1, t2)) {
            return true;
        }
        if (checkSubTree(t1.left, t2)) {
            return true;
        }
        if (checkSubTree(t1.right, t2)) {
            return true;
        }
        return false;
    }

    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (null == t1 || t2 == null) {
            return t1 == null && t2 == null;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}