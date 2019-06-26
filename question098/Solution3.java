package question098;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83338196
 */
public class Solution3 {

    Integer pre = null;

    public boolean isValidBST(TreeNode root) {
        return inorderTraversal(root);
    }

    private boolean inorderTraversal(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorderTraversal(root.left)) {
            return false;
        }
        if (pre != null && root.val <= pre) {
            return false;
        }
        pre = root.val;
        if (!inorderTraversal(root.right)) {
            return false;
        }
        return true;
    }
}
