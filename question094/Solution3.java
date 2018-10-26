package question094;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82056504
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution3 {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
        	return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
        	if(cur != null) {
        		stack.push(cur);
        		cur = cur.left;
        	}else {
        		cur = stack.pop();
        		list.add(cur.val);
        		cur = cur.right;
        	}
        }
        return list;
	}
}
