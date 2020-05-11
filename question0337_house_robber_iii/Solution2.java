package question0337_house_robber_iii;

/**
 * 时间复杂度和空间复杂度均是O(n)，其中n是树中的节点个数。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：39.5MB，击败33.33%。
 */
public class Solution2 {
    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    // 返回值是一个二维数组，第一个元素代表不抢劫根节点所能得到的最大值，第二个元素代表抢劫根节点所能得到的最大值
    private int[] robHelper(TreeNode root) {
        if (null == root) {
            return new int[] {0, 0};
        }
        int[] left = robHelper(root.left), right = robHelper(root.right);
        return new int[] {Math.max(left[0], left[1]) + Math.max(right[0], right[1]), root.val + left[0] + right[0]};
    }
}