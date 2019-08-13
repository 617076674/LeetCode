package question0333;

/**
 * @author qianyihui
 * @date 2019-08-13
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：4ms，击败32.50%。消耗内存：38.1MB，击败100.00%。
 */
public class Solution {
    private int result = 0;

    public int largestBSTSubtree(TreeNode root) {
        largest(root);
        return result;
    }

    /**
     * 递归函数的定义为：求以root为根节点的树中的最大值、最小值以及BST的大小，如果不是BST，则BST大小为-1。
     * 返回的int数组中的值分别为[子树最大值，子树最小值,子树BST的大小（为-1表示不是BST）]
     */
    public Integer[] largest(TreeNode root) {
        if (root == null) {
            return new Integer[]{null, null, 0};
        }
        Integer[] left = largest(root.left);
        Integer[] right = largest(root.right);
        if (left[2] < 0 || right[2] < 0) {
            return new Integer[]{0, 0, -1};
        }
        if ((left[0] != null && root.val <= left[0]) || (right[1] != null && root.val >= right[1])) {
            return new Integer[]{0, 0, -1};
        }
        int max = right[0] == null ? root.val : right[0];
        int min = left[1] == null ? root.val : left[1];
        result = Math.max(result, left[2] + right[2] + 1);
        return new Integer[]{max, min, left[2] + right[2] + 1};
    }
}
