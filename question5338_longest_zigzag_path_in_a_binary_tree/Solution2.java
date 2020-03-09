package question5338_longest_zigzag_path_in_a_binary_tree;

/**
 * 深搜。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：6ms，击败100.00%。消耗内存53.8MB，击败100.00%。
 */
public class Solution2 {
    private int result;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, -1, 1);
        dfs(root.right, 1, 1);
        return result;
    }

    private void dfs(TreeNode root, int last, int len) {
        if (null == root) {
            return;
        }
        result = Math.max(result, len);
        if (last == -1) {
            dfs(root.left, -1, 1);
            dfs(root.right, 1, len + 1);
        } else {
            dfs(root.left, -1, len + 1);
            dfs(root.right, 1, 1);
        }
    }
}