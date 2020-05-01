package question0549_binary_tree_longest_consecutive_sequence_ii;

/**
 * 执行用时：1ms，击败98.97%。消耗内存：39.7MB，击败100.00%。
 */
public class Solution {
    private int result;

    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return result;
    }

    public int[] longestPath(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int increase = 1, decrease = 1;
        if (root.left != null) {
            int[] leftResult = longestPath(root.left);
            if (root.val == root.left.val + 1) {
                decrease = leftResult[1] + 1;
            } else if (root.val == root.left.val - 1) {
                increase = leftResult[0] + 1;
            }
        }
        if (root.right != null) {
            int[] rightResult = longestPath(root.right);
            if (root.val == root.right.val + 1) {
                decrease = Math.max(decrease, rightResult[1] + 1);
            } else if (root.val == root.right.val - 1) {
                increase = Math.max(increase, rightResult[0] + 1);
            }
        }
        result = Math.max(result, decrease + increase - 1);
        return new int[]{increase, decrease};
    }
}