package question0235_lowest_common_ancestor_of_a_binary_search_tree;

/**
 * 循环实现。
 *
 * 时间复杂度是O(h)，其中h是树的高度。空间复杂度是O(1)。
 *
 * 执行用时：8ms，击败89.85%。消耗内存：35.3MB，击败83.84%。
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else if (cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }
}