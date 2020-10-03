package question1038_binary_search_tree_to_greater_sum_tree;

/**
 * 逆序中序遍历。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.6MB，击败47.80%。
 */
public class Solution {

    private int sum;

    public TreeNode bstToGst(TreeNode root) {
        if (null != root) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }

}