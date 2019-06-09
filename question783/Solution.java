package question783;

/**
 * 中序遍历二叉树即可。
 *
 * 一个小技巧，将pre声明为Integer类型并初始化为null，就可以根据其是否为null来确定是否是第一个节点。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(logh)，其中h为二叉树的高度。
 *
 * 执行时间：2ms，击败64.45%。使用内存34.3MB，击败80.95%。
 */
public class Solution {

    private int result = Integer.MAX_VALUE;

    private Integer pre = null;

    public int minDiffInBST(TreeNode root) {
        inOrderTraversal(root);
        return result;
    }

    private void inOrderTraversal(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        if (null != treeNode.left) {
            inOrderTraversal(treeNode.left);
        }
        if (null == pre) {
            pre = treeNode.val;
        } else {
            result = Math.min(result, treeNode.val - pre);
            pre = treeNode.val;
        }
        if (null != treeNode.right) {
            inOrderTraversal(treeNode.right);
        }
    }

}
