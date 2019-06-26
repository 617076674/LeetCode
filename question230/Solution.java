package question230;

public class Solution {
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
            TreeNode tempNode = node.right;
            return tempNode;
        }
        node.left = delMin(node.left);
        return node;
    }
}
