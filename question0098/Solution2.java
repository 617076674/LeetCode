package question0098;

/**
 * 中序遍历，只保留一个前驱节点。
 *
 * 时间复杂度是O(n)，其中n是树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：2ms，击败61.59%。消耗内存：39.2MB，击败26.90%。
 */
public class Solution2 {
    Integer pre = null;

    public boolean isValidBST(TreeNode root) {
        return inorderTraversal(root);
    }

    private boolean inorderTraversal(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorderTraversal(root.left)) {
            return false;
        }
        if (pre != null && root.val <= pre) {
            return false;
        }
        pre = root.val;
        if (!inorderTraversal(root.right)) {
            return false;
        }
        return true;
    }
}
