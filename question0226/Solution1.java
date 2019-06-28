package question0226;

/**
 * 递归翻转即可。需要注意的是，由于新的左子树是由右子树翻转而来的，而新的右子树是由原左子树翻转而来的。
 * 因此，需要先记录原左子树和原右子树，否则原左子树会找不到。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h是二叉树的高度。
 *
 * 执行用时：1ms，击败82.20%。消耗内存：34.7MB，击败38.99%。
 */
public class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
