package question0938_range_sum_of_bst;

/**
 * 递归解决。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：1ms，击败99.70%。消耗内存：54.1MB，击败19.51%。
 */
public class Solution {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (null == root) {
            return 0;
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        return root.val + rangeSumBST(root.left, L, root.val) + rangeSumBST(root.right, root.val, R);
    }

}
