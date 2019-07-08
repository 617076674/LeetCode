package question0104;

/**
 * 递归实现即可。
 *
 * 时间复杂度是O(n)，其中n是二叉树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：1ms，击败99.11%。消耗内存：37.5MB，击败44.32%。
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
