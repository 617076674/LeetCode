package question0285;

/**
 * @author qianyihui
 * @date 2019-08-01
 *
 * 中序遍历，递归实现。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：6ms，击败67.50%。消耗内存：41.1MB，击败100.00%。
 */
public class Solution1 {
    private TreeNode pre = null;

    private TreeNode result = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inOrder(root, p);
        return result;
    }

    private void inOrder(TreeNode root, TreeNode p) {
        if (null == root || null != result) {
            return;
        }
        inOrder(root.left, p);
        if (pre == p) {
            result = root;
        }
        pre = root;
        inOrder(root.right, p);
    }
}
