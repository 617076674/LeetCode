package question0543_diameter_of_binary_tree;

/**
 * 深度优先遍历。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.6MB，击败5.08%。
 */
public class Solution {
    private int result = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        maxPathFromRoot(root);
        return result - 1;
    }

    private int maxPathFromRoot(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = maxPathFromRoot(root.left), right = maxPathFromRoot(root.right);
        result = Math.max(result, left + right + 1);
        return Math.max(left, right) + 1;
    }
}