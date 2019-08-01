package question0270;

/**
 * @author qianyihui
 * @date 2019-08-01
 *
 * 中序遍历。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：38.2MB，击败100.00%。
 */
public class Solution1 {
    private int result;

    private Integer pre = null;

    private Double gap = null;

    public int closestValue(TreeNode root, double target) {
        inOrder(root, target);
        return result;
    }

    private void inOrder(TreeNode root, double target) {
        if (null == root) {
            return;
        }
        if (null != pre && pre > target) {
            return;
        }
        inOrder(root.left, target);
        if (gap == null) {
            gap = Math.abs(target - root.val);
            result = root.val;
        } else if (Math.abs(target - root.val) < gap) {
            gap = Math.abs(target - root.val);
            result = root.val;
        }
        pre = root.val;
        inOrder(root.right, target);
    }
}
