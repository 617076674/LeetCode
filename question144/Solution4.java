package question144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution4 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()) {
			while(cur != null) {
				list.add(cur.val);
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			cur = cur.right;
		}
		return list;
	}
}
