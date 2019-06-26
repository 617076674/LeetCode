package question098;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83338196
 */
public class Solution1 {

    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null && root.right != null) {
            if (root.val < findMinTreeNode(root.right) && isValidBST(root.right)) {
                return true;
            }
        } else if (root.left != null && root.right == null) {
            if (root.val > findMaxTreeNode(root.left) && isValidBST(root.left)) {
                return true;
            }
        } else if (root.left != null && root.right != null) {
            if (root.val < findMinTreeNode(root.right) && root.val > findMaxTreeNode(root.left) && isValidBST(root.left) && isValidBST(root.right)) {
                return true;
            }
        }
        return false;
    }

    private int findMinTreeNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    private int findMaxTreeNode(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
