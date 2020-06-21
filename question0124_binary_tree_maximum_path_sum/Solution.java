package question0124_binary_tree_maximum_path_sum;

/**
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：1ms，击败99.55%。消耗内存：41.6MB，击败7.69%。
 */
public class Solution {
    private int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathSumFromRoot(root);
        return maxSum;
    }
    
    private int maxPathSumFromRoot(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftResult = maxPathSumFromRoot(root.left), rightResult = maxPathSumFromRoot(root.right),
                result = root.val + Math.max(leftResult, Math.max(0, rightResult));
        maxSum = Math.max(result, Math.max(maxSum, leftResult + rightResult + root.val));
        return result;
    }
}