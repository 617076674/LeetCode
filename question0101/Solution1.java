package question0101;

/**
 * 递归实现。新建一个函数，判断两个二叉树是否是对称二叉树。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h是二叉树的高度。
 *
 * 执行用时：2ms，击败85.03%。消耗内存：35.3MB，击败81.83%。
 */
public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null) {
            return false;
        } else if (node2 == null) {
            return false;
        } else if (node1.val != node2.val) {
            return false;
        }
        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }
}
