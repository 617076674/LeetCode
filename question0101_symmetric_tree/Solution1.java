package question0101_symmetric_tree;

/**
 * 递归实现。新建一个函数，判断两个二叉树是否是对称二叉树。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h是二叉树的高度。
 *
 * 执行用时：2ms，击败85.03%。消耗内存：35.3MB，击败81.83%。
 */
public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode treeNode1, TreeNode treeNode2) {
        if (null == treeNode1 && null == treeNode2) {
            return true;
        }
        if (null == treeNode1 || null == treeNode2) {
            return false;
        }
        if (treeNode1.val != treeNode2.val) {
            return false;
        }
        return isSymmetric(treeNode1.left, treeNode2.right) && isSymmetric(treeNode1.right, treeNode2.left);
    }
}