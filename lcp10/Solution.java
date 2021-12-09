package lcp10;

public class Solution {

    public double minimalExecTime(TreeNode root) {
        double[] result = dfs(root);
        return result[0] - result[1];
    }

    private double[] dfs(TreeNode treeNode) {
        if (null == treeNode) {
            return new double[] {0.0, 0.0};
        }
        double[] leftResult = dfs(treeNode.left), rightResult = dfs(treeNode.right);
        double[] result = new double[2];
        result[0] = leftResult[0] + rightResult[0] + treeNode.val;
        if (leftResult[0] < rightResult[0]) {
            double[] temp = leftResult;
            leftResult = rightResult;
            rightResult = temp;
        }
        if (leftResult[0] - rightResult[0] <= 2 * leftResult[1]) {
            result[1] = (leftResult[0] + rightResult[0]) / 2;
        } else {
            result[1] = leftResult[1] + rightResult[0];
        }
        return result;
    }

}