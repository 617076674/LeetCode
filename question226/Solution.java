package question226;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        TreeNode leftChild = invertTree(root.right);
        TreeNode rightChild = invertTree(root.left);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
