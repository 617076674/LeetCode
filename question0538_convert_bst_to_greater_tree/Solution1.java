package question0538_convert_bst_to_greater_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    private List<TreeNode> inOrder = new ArrayList<>();

    private int sum;

    public TreeNode convertBST(TreeNode root) {
        inOrderTraversal(root);
        for (TreeNode treeNode : inOrder) {
            sum -= treeNode.val;
            treeNode.val += sum;
        }
        return root;
    }

    private void inOrderTraversal(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        inOrderTraversal(treeNode.left);
        inOrder.add(treeNode);
        sum += treeNode.val;
        inOrderTraversal(treeNode.right);
    }

}