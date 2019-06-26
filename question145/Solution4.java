package question145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution4 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode treeNode = stack1.pop();
            stack2.push(treeNode.val);
            if (treeNode.left != null) {
                stack1.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack1.push(treeNode.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop());
        }
        return list;
    }
}

