package question0404_sum_of_left_leaves;

/**
 * 递归。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.8MB，击败63.98%。
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (null == root || (null == root.left && null == root.right)) {
            return 0;
        }
        int result = 0;
        if (null != root.left && null == root.left.left && null == root.left.right) {
            result += root.left.val;
        }
        return result + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}