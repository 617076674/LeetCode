package question0144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归实现。这个过程很像层序遍历的过程，只不过这里用的是栈，而层序遍历时用的是队列。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：2ms，击败57.92%。消耗内存：34.7MB，击败40.77%。
 */
public class Solution3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            //在访问本节点后先入栈右孩子，再入栈左孩子
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return list;
    }
}
