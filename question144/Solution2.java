package question144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
	private class Command {
		String s;
		TreeNode treeNode;
		public Command(String s, TreeNode treeNode) {
			this.s = s;
			this.treeNode = treeNode;
		}
	}
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<Command> stack = new Stack<>();
		stack.push(new Command("go", root));
		while(!stack.isEmpty()) {
			Command command = stack.pop();
			if(command.s.equals("visit")) {
				list.add(command.treeNode.val);
			}
			if(command.s.equals("go") && command.treeNode != null) {
				stack.push(new Command("go", command.treeNode.right));
				stack.push(new Command("go", command.treeNode.left));
				stack.push(new Command("visit", command.treeNode));
			}
		}
		return list;
	}
}
