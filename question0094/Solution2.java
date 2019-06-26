package question0094;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 自定义栈来代替系统栈。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h为二叉树的高度。
 *
 * 执行用时：3ms，击败55.16%。消耗内存：35.3MB，击败39.36%。
 */
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
                //中序遍历的顺序是：左子树->当前节点->右子树，因此入栈顺序是右子树->当前节点->左子树
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
