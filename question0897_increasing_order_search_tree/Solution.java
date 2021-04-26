package question0897_increasing_order_search_tree;

/**
 *
 * 中序遍历。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：12ms，击败75.85%。消耗内存：52.5MB，击败52.50%。
 */
public class Solution {

    private TreeNode pre, firstNode;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return firstNode;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (null == pre) {
            firstNode = node;
        } else {
            pre.right = node;
            node.left = null;
        }
        pre = node;
        inorder(node.right);
    }

}