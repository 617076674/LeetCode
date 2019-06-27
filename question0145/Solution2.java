package question0145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 自定义栈来代替递归的系统栈。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h为二叉树的高度。
 *
 * 执行用时：3ms，击败12.02%。消耗内存：35MB，击败37.05%。
 */
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
        if (root == null) {
            return list;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if ("visit".equals(command.s)) {
                list.add(command.treeNode.val);
            }
            //后序遍历的顺序是：左子树->右子树->当前节点，因此入栈顺序是：当前节点->右子树->左子树
            if ("go".equals(command.s) && command.treeNode != null) {
                stack.push(new Command("visit", command.treeNode));
                stack.push(new Command("go", command.treeNode.right));
                stack.push(new Command("go", command.treeNode.left));
            }
        }
        return list;
    }
}
