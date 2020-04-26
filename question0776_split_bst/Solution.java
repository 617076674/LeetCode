package question0776_split_bst;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：37.6MB，击败100.00%。
 */
public class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (null == root) {
            return new TreeNode[] {null, null};
        }
        if (root.val == V) {
            TreeNode treeNode = root.right;
            root.right = null;
            return new TreeNode[] {root, treeNode};
        } else if (root.val > V) {
            TreeNode[] leftResult = splitBST(root.left, V);
            root.left = leftResult[1];
            return new TreeNode[] {leftResult[0], root};
        }
        TreeNode[] rightResult = splitBST(root.right, V);
        root.right = rightResult[0];
        return new TreeNode[] {root, rightResult[1]};
    }
}