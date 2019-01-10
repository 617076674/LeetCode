package question145;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while(!stack.isEmpty()) {
            Command command = stack.pop();
            if("visit".equals(command.s)) {
                list.add(command.treeNode.val);
            }
            if("go".equals(command.s) && command.treeNode != null) {
                stack.push(new Command("visit", command.treeNode));
                stack.push(new Command("go", command.treeNode.right));
                stack.push(new Command("go", command.treeNode.left));
            }
        }
        return list;
    }
}
