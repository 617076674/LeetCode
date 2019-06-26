package question094;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82056504
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    private class Command {
        String s;        //go, print
        TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.s.equals("print")) {
                res.add(command.node.val);
            } else {
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                stack.push(new Command("print", command.node));
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
            }
        }
        return res;
    }
}
