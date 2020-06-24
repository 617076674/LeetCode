package question0968_binary_tree_cameras;

/**
 * 深度优先遍历。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：1ms，击败57.68%。消耗内存：39.6MB，击败50.00%。
 */
public class Solution {
    private enum Status {
        NEED,   // 该节点需要监视器来监视
        NO_NEED,    // 该节点不需要监视器来监视
        MONITOR // 该节点本身就是一个监视器
    }

    private int result;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == Status.NEED) {
            result++;
        }
        return result;
    }

    private Status dfs(TreeNode root) {
        if (root == null)  {
            return Status.NO_NEED;
        }
        Status left = dfs(root.left), right = dfs(root.right);
        if (left == Status.NEED || right == Status.NEED) {
            result++;
            return Status.MONITOR;
        }
        if (left == Status.MONITOR || right == Status.MONITOR) {
            return Status.NO_NEED;
        }
        return Status.NEED;
    }
}