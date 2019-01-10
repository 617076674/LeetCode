package question145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution5 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack1.isEmpty()) {
            while(cur != null) {
                stack1.push(cur);
                stack2.push(cur.val);
                cur = cur.right;
            }
            cur = stack1.pop();
            cur = cur.left;
        }
        while(!stack2.isEmpty()) {
            list.add(stack2.pop());
        }
        return list;
    }
}

