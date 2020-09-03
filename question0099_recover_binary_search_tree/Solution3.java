package question0099_recover_binary_search_tree;

/**
 * 参考Solution2的思路，既然我们的目的仅仅寻找到中序遍历序列的下降沿，没必要用一个list来保存中序遍历的结果，只需要在中序遍历时保存前驱节点。
 *
 * 时间复杂度是O(n)，其中n是树中的节点个数。空间复杂度是O(1)。
 *
 * 执行用时：3ms，击败100.00%。消耗内存：37.6MB，击败98.80%。
 */
public class Solution3 {
    private TreeNode wrongTreeNode1 = null;

    private TreeNode wrongTreeNode2 = null;

    private TreeNode pre = null;

    private int countDown;

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int tmp = wrongTreeNode1.val;
        wrongTreeNode1.val = wrongTreeNode2.val;
        wrongTreeNode2.val = tmp;
    }

    /**
     * 为了满足题目空间复杂度的要求，必须使用Morris中序遍历。
     */
    private void inorderTraversal(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                if (pre != null) {
                    if (cur.val < pre.val) {
                        if (countDown++ == 0) {
                            wrongTreeNode1 = pre;
                        }
                        wrongTreeNode2 = cur;
                    }
                }
                pre = cur;
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
                    if (cur.val < pre.val) {
                        if (countDown == 0) {
                            wrongTreeNode1 = pre;
                        }
                        wrongTreeNode2 = cur;
                        countDown++;
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
        }
    }
}