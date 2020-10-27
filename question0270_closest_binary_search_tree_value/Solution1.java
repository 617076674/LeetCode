package question0270_closest_binary_search_tree_value;

/**
 * 中序遍历。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：38.2MB，击败100.00%。
 */
public class Solution1 {

    private int result;

    private Integer pre = Integer.MIN_VALUE;

    private Double gap = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        inOrder(root, target);
        return result;
    }

    private void inOrder(TreeNode root, double target) {
        if (null == root) {
            return;
        }
        if (pre > target) {
            return;
        }
        inOrder(root.left, target);
        if (Math.abs(target - root.val) < gap) {
            gap = Math.abs(target - root.val);
            result = root.val;
        }
        pre = root.val;
        inOrder(root.right, target);
    }

}