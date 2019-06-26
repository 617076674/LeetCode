package question0144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 自定义栈来代替系统栈。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：3ms，击败57.92%。消耗内存：35.4MB，击败40.72%。
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.s.equals("visit")) {
                list.add(command.treeNode.val);
            }
            if (command.s.equals("go") && command.treeNode != null) {
                //因为访问顺序是本节点->左孩子->右孩子，因此入栈顺序刚好相反，即右孩子->左孩子->本节点
                stack.push(new Command("go", command.treeNode.right));
                stack.push(new Command("go", command.treeNode.left));
                stack.push(new Command("visit", command.treeNode));
            }
        }
        return list;
    }
}
