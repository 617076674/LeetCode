package question1145_binary_tree_coloring_game;

/**
 * 后序遍历。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.3MB，击败88.73%。
 */
public class Solution {

    private int part;

    private int partLeft;

    private int partRight;

    private int x;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (null == root) {
            return true;
        }
        this.x = x;
        int total = postOrderTraversal(root);
        int max = Math.max(total - part, Math.max(partLeft, partRight));
        return max > total - max;
    }

    private int postOrderTraversal(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftResult = postOrderTraversal(root.left);
        int rightResult = postOrderTraversal(root.right);
        int result = leftResult + rightResult + 1;
        if (root.val == x) {
            part = result;
            partLeft = leftResult;
            partRight = rightResult;
        }
        return result;
    }

}