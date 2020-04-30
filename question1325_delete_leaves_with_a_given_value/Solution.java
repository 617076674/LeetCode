package question1325_delete_leaves_with_a_given_value;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：39.1MB，击败100.00%。
 */
public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null || (root.val == target && isTargetTree(root.left, target) && isTargetTree(root.right, target))) {
            return null;
        }
        if (isTargetTree(root.left, target)) {
            root.left = null;
        }
        if (isTargetTree(root.right, target)) {
            root.right = null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        return root;
    }

    private boolean isTargetTree(TreeNode treeNode, int target) {
        if (null == treeNode) {
            return true;
        }
        if (treeNode.val != target) {
            return false;
        }
        return isTargetTree(treeNode.left, target) && isTargetTree(treeNode.right, target);
    }
}