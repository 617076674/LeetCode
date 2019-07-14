package question0606;

/**
 * @author qianyihui
 * @date 2019-07-14
 *
 * 前序遍历。
 * （1）如果左右子树均为空，不输出空括号。
 * （2）如果左子树为空而右子树不为空，输出代表左子树的空括号。
 * （3）如果左子树不为空右子树为空，不输出空括号。
 *
 * 时间复杂度是O(n)，其中n是树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：6ms，击败68.79%。消耗内存：40.2MB，击败89.03%。
 */
public class Solution {
    private StringBuilder result = new StringBuilder();

    public String tree2str(TreeNode t) {
        preOrderTraversal(t);
        return result.toString();
    }

    private void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        result.append(root.val);
        if (root.left == root.right) {
            return;
        }
        result.append("(");
        preOrderTraversal(root.left);
        result.append(")");
        if (root.right != null) {
            result.append("(");
            preOrderTraversal(root.right);
            result.append(")");
        }
    }
}
