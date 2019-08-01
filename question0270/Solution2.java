package question0270;

/**
 * @author qianyihui
 * @date 2019-08-01
 *
 * 二分查找。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：38.1MB，击败100.00%。
 */
public class Solution2 {
    public int closestValue(TreeNode root, double target) {
        if (target > root.val) {
            if (root.right == null) {
                return root.val;
            } else {
                double gap1 = Math.abs(root.val - target);
                int rightResult = closestValue(root.right, target);
                double gap2 = Math.abs(rightResult - target);
                return gap1 < gap2 ? root.val : rightResult;
            }
        } else {
            if (root.left == null) {
                return root.val;
            } else {
                double gap1 = Math.abs(root.val - target);
                int leftResult = closestValue(root.left, target);
                double gap2 = Math.abs(leftResult - target);
                return gap1 < gap2 ? root.val : leftResult;
            }
        }
    }
}
