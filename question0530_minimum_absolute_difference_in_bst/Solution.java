package question0530_minimum_absolute_difference_in_bst;

/**
 * 中序遍历时记录前驱节点即可。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：40.7MB，击败78.51%。
 */
public class Solution {

    private int result = Integer.MAX_VALUE;

    private Integer pre = null;

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return result;
    }

    private void inOrderTraversal(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        inOrderTraversal(treeNode.left);
        if (pre != null) {
            result = Math.min(result, treeNode.val - pre);
        }
        pre = treeNode.val;
        inOrderTraversal(treeNode.right);
    }

}