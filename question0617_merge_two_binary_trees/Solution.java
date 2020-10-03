package question0617_merge_two_binary_trees;

/**
 * 递归。
 *
 * 时间复杂度是O(max(n1, n2))，其中n1是树t1中的节点个数，n2是树t2中的节点个数。空间复杂度是O(max(h1, h2))，其中h1是树t1的高度，
 * h2是树t2的高度。
 *
 * 执行用时：1ms，击败99.72%。消耗内存：40MB，击败95.85%。
 */
public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        treeNode.left = mergeTrees(t1.left, t2.left);
        treeNode.right = mergeTrees(t1.right, t2.right);
        return treeNode;
    }

}