package question1382_balance_a_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> inOrder = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrderTraversal(root);
        return sortedArrayToBST(inOrder, 0, inOrder.size() - 1);
    }

    private void inOrderTraversal(TreeNode root) {
        if (null == root) {
            return;
        }
        inOrderTraversal(root.left);
        inOrder.add(root.val);
        inOrderTraversal(root.right);
    }

    public TreeNode sortedArrayToBST(List<Integer> list, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        TreeNode treeNode = new TreeNode(list.get(mid));
        treeNode.left = sortedArrayToBST(list, left, mid - 1);
        treeNode.right = sortedArrayToBST(list, mid + 1, right);
        return treeNode;
    }
}