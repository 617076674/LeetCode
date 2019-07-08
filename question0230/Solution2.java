package question0230;

/**
 * 如果二叉树经常被修改，用递归来实现。每次删除最小的节点，但这会改变原树的结构。
 *
 * 时间复杂度是O(k)。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败77.98%。消耗内存：40.4MB，击败32.72%。
 */
public class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        if (k == 1) {
            TreeNode cur = root;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur.val;
        }
        root = delMin(root);
        return kthSmallest(root, k - 1);
    }

    private TreeNode delMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = delMin(node.left);
        return node;
    }
}
