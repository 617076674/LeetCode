package question0538_convert_bst_to_greater_tree;

/**
 * 反序中序遍历。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：1ms，击败97.82%。消耗内存：39MB，击败51.36%。
 */
public class Solution2 {

    private int sum;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}