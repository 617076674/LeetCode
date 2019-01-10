package question145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution8 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if(cur.right == null || pre == cur.right) {
                    list.add(cur.val);
                    pre = cur;
                    cur = null;
                }else {
                    stack.push(cur);
                    cur = cur.right;
                }
            }
        }
        return list;
    }
}

