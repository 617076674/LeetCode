package question0897;

/**
 * @author qianyihui
 * @date 2019-07-11
 *
 * 中序遍历。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：12ms，击败75.85%。消耗内存：52.5MB，击败52.50%。
 */
public class Solution {
    private TreeNode dummyHead = new TreeNode(-1);

    private TreeNode cur = dummyHead;

    public TreeNode increasingBST(TreeNode root) {
        inOrderTraversal(root);
        return dummyHead.right;
    }

    private void inOrderTraversal(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        inOrderTraversal(treeNode.left);
        cur.right = new TreeNode(treeNode.val);
        cur = cur.right;
        inOrderTraversal(treeNode.right);
    }
}
