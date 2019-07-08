package question0230;

/**
 * @author qianyihui
 * @date 2019-07-08
 *
 * 二叉树的中序遍历。
 *
 * 时间复杂度是O(k)。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败77.98%。消耗内存：40.4MB，击败32.72%。
 */
public class Solution1 {
    public int kthSmallest(TreeNode root, int k) {
        return inOrder(root, k);
    }

    private int inOrder(TreeNode treeNode, int k) {
        TreeNode cur = treeNode;
        while (cur != null) {
            if (cur.left == null) {
                if (--k == 0) {
                    return cur.val;
                }
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    if (--k == 0) {
                        return cur.val;
                    }
                    cur = cur.right;
                }
            }
        }
        return -1;
    }
}
