package question1026;

/**
 * @author qianyihui
 * @date 2019-07-21
 *
 * 递归
 *
 * 执行用时：1ms，击败99.68%。消耗内存：36.9MB，击败100.00%。
 */
public class Solution {

    private int result = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        if (null == root) {
            return result;
        }
        maxAncestorDiff(root, root.val, root.val);
        return result;
    }

    /**
     * 现在我们正处于节点root，目前的最大值是max，最小值是min
     */
    private void maxAncestorDiff(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }
        result = Math.max(result, Math.max(Math.abs(max - root.val), Math.abs(min - root.val)));
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        maxAncestorDiff(root.left, max, min);
        maxAncestorDiff(root.right, max, min);
    }
}
