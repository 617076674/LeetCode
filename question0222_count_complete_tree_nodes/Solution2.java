package question0222_count_complete_tree_nodes;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：40.7MB，击败94.64%。
 */
public class Solution2 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 0;
        TreeNode curLeft = root;
        while (curLeft.left != null) {
            curLeft = curLeft.left;
            leftDepth++;
        }
        int rightDepth = 0;
        TreeNode curRight = root;
        while (curRight.right != null) {
            curRight = curRight.right;
            rightDepth++;
        }
        if (rightDepth == leftDepth) {
            return (int) (Math.pow(2, leftDepth + 1) - 1);
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}