package question0250_count_univalue_subtrees;

/**
 * https://leetcode-cn.com/problems/count-univalue-subtrees/
 *
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：1ms，击败92.75%。消耗内存：36MB，击败100.00%。
 */
public class Solution2 {
    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (null == root) {
            return 0;
        }
        isUniqueTree(root);
        return count;
    }

    private boolean isUniqueTree(TreeNode node) {
        if (null == node.left && null == node.right) {
            count++;
            return true;
        }
        boolean isUnique = true;
        if (null != node.left) {
            isUnique = isUniqueTree(node.left) && node.left.val == node.val;
        }
        if (null != node.right) {
            isUnique = isUniqueTree(node.right) && isUnique && node.right.val == node.val;
        }
        if (!isUnique) {
            return false;
        }
        count++;
        return true;
    }
}