package question0563_binary_tree_tilt;

/**
 * 后序遍历。注意：需要求解的值是坡度之和，而后序遍历返回的是树中节点的和，是两个不一样的量！！！
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：2ms，击败92.64%。消耗内存：40.8MB，击败57.58%。
 */
public class Solution {

    private int result;

    public int findTilt(TreeNode root) {
        postOrder(root);
        return result;
    }

    public int postOrder(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftResult = postOrder(root.left);
        int rightResult = postOrder(root.right);
        result += Math.abs(leftResult - rightResult);
        return leftResult + rightResult + root.val;
    }

}
