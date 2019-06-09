package question965;

/**
 * 遍历二叉树即可。遍历过程既可以中序遍历也可以前序遍历，也可以后序遍历，甚至可以层序遍历。
 *
 * 一旦遇到不同的值就将result变量置为false。
 *
 * 执行时间：1ms，击败96.72%。消耗内存34.3MB，击败83.94%。
 */
public class Solution {

    private Integer value = null;

    private boolean result = true;

    public boolean isUnivalTree(TreeNode root) {
        preOrderTraversal(root);
        return result;
    }

    private void preOrderTraversal(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        if (null == value) {
            value = treeNode.val;
        } else if (value != treeNode.val) {
            result = false;
            return;
        }
        if (null != treeNode.left) {
            preOrderTraversal(treeNode.left);
        }
        if (null != treeNode.right) {
            preOrderTraversal(treeNode.right);
        }
    }

}