package question124;

public class Solution {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return result;
    }

    private int maxSum(TreeNode root) {  //求包含root根节点的最大路径和
        if (null == root) {
            return 0;
        }
        int data = root.val;
        int maxL = maxSum(root.left);
        if (maxL > 0) {
            data += maxL;
        }
        int maxR = maxSum(root.right);
        if (maxR > 0) {
            data += maxR;
        }
        result = Math.max(result, data);    //记录当前树的最大路径和
        return Math.max(root.val, Math.max(root.val + maxL, root.val + maxR));
    }
}