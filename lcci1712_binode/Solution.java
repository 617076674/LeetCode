package lcci1712_binode;

/**
 * 执行用时：1ms，击败72.90%。消耗内存：44.9MB，击败100.00%。
 */
public class Solution {
    public TreeNode convertBiNode(TreeNode root) {
        if (null == root) {
            return root;
        }
        TreeNode leftResult = convertBiNode(root.left), rightResult = convertBiNode(root.right);
        root.left = null;
        root.right = rightResult;
        if (null == leftResult) {
            return root;
        }
        TreeNode cur = leftResult;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = root;
        return leftResult;
    }
}