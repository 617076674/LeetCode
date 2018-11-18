package question101;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81582778
 */
public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }else if(root.left == null && root.right == null) {
            return true;
        }else if(root.left != null && root.right == null) {
            return false;
        }else if(root.left == null && root.right != null) {
            return false;
        }else {
            return isSameTree(root.left, inverseTree(root.right));
        }
    }

    private TreeNode inverseTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        inverseTree(root.left);
        inverseTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }else if(p == null && q != null) {
            return false;
        }else if(p != null && q == null) {
            return false;
        }else if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
