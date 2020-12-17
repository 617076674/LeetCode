package question1315_sum_of_nodes_with_even_valued_grandparent;

public class Solution {

    private int result;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, false);
        return result;
    }

    private void dfs(TreeNode treeNode, boolean isParentEven) {
        if (null == treeNode) {
            return;
        }
        if (isParentEven) {
            if (null != treeNode.left) {
                result += treeNode.left.val;
            }
            if (null != treeNode.right) {
                result += treeNode.right.val;
            }
        }
        boolean isEven = (treeNode.val & 1) == 0;
        dfs(treeNode.left, isEven);
        dfs(treeNode.right, isEven);
    }

}