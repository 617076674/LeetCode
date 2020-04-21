package lcci0412_paths_with_sum;

/**
 * 用一个数组paths记录从根节点到当前节点的所有节点值。
 *
 * 时间复杂度是O(nlogn)。空间复杂度是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：39.3MB，击败100.00%。
 */
public class Solution {
    private int result = 0;

    private int[] paths;

    public int pathSum(TreeNode root, int sum) {
        paths = new int[getHeight(root)];
        pathSum(root, sum, 0);
        return result;
    }

    private void pathSum(TreeNode root, int sum, int level) {
        if (root == null) {
            return;
        }
        paths[level] = root.val;
        int t = 0;
        for (int i = level; i >= 0; i--) {
            t += paths[i];
            if (t == sum) {
                result++;
            }
        }
        pathSum(root.left, sum, level + 1);
        pathSum(root.right, sum, level + 1);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}