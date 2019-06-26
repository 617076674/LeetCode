package question145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution6 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if ((treeNode.left == null && treeNode.right == null) || (pre != null && pre == treeNode.left && treeNode.right == null) || (pre != null && pre == treeNode.right)) {
                list.add(treeNode.val);
                pre = treeNode;
            } else {
                stack.push(treeNode);
                if (treeNode.right != null) {
                    stack.push(treeNode.right);
                }
                if (treeNode.left != null) {
                    stack.push(treeNode.left);
                }
            }
        }
        return list;
    }
}

