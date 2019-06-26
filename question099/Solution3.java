package question099;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83374178
 */
public class Solution3 {

    TreeNode wrongTreeNode1 = null;
    TreeNode wrongTreeNode2 = null;
    TreeNode pre = null;
    int countDown = 0;

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = wrongTreeNode1.val;
        wrongTreeNode1.val = wrongTreeNode2.val;
        wrongTreeNode2.val = temp;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        if (pre != null) {
            if (root.val < pre.val) {
                if (countDown == 0) {
                    wrongTreeNode1 = pre;
                }
                wrongTreeNode2 = root;
                countDown++;
            }
        }
        pre = root;
        inorderTraversal(root.right);
    }
}
