package lcof26_shu_de_zi_jie_gou;

public class Solution {

    private boolean result;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == B) {
            return result;
        }
        dfs(A, B);
        return result;
    }

    private void dfs(TreeNode treeNode, TreeNode subTreeNode) {
        if (null == treeNode || result) {
            return;
        }
        if (isSubTree(treeNode, subTreeNode)) {
            result = true;
        }
        dfs(treeNode.left, subTreeNode);
        dfs(treeNode.right, subTreeNode);
    }

    private boolean isSubTree(TreeNode treeNode1, TreeNode treeNode2) {
        if (null == treeNode1 && null == treeNode2) {
            return true;
        }
        if (null == treeNode2) {
            return true;
        }
        if (null == treeNode1) {
            return false;
        }
        return treeNode1.val == treeNode2.val && isSubTree(treeNode1.left, treeNode2.left) &&
            isSubTree(treeNode1.right, treeNode2.right);
    }

}