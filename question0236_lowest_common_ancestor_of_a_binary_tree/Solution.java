package question0236_lowest_common_ancestor_of_a_binary_tree;

/**
 * 递归。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：15ms，击败82.17%。消耗内存：38.4MB，击败16.10%。
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果root为null或者root是p或q中的某一个节点，直接返回root
        if (root == null || root == p || root == q) {
            return root;
        }
        //在左子树中寻找最近祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //在右子树中寻找最近祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左子树中没找到，说明左子树为null或者左子树中没有p也没有q
        if (null == left) {
            return right;
        }
        //右子树中没找到，说明右子树为null或者右子树中没有p也没有q
        if (null == right) {
            return left;
        }
        return root;
    }
}
