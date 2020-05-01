package question1120_maximum_average_subtree;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：40.2MB，击败100.00%。
 */
public class Solution {
    private double result;

    public double maximumAverageSubtree(TreeNode root) {
        countNodesAndSum(root);
        return result;
    }

    private double[] countNodesAndSum(TreeNode root) {
        if (null == root) {
            return new double[]{0, 0};
        }
        double[] leftResult = countNodesAndSum(root.left), rightResult = countNodesAndSum(root.right);
        result = Math.max(result, (leftResult[1] + rightResult[1] + root.val) / (leftResult[0] + rightResult[0] + 1));
        return new double[]{leftResult[0] + rightResult[0] + 1, leftResult[1] + rightResult[1] + root.val};
    }
}