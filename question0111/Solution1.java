package question0111;

/**
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：1ms，击败99.73%。消耗内存：37.2MB，击败71.56%。
 */
public class Solution1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left != null) {
            return minDepth(root.left) + 1;
        }
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
