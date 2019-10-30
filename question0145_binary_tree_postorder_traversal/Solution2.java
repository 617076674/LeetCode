package question0145_binary_tree_postorder_traversal;

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
    private class WrapperNode {
        boolean visited;

        TreeNode node;

        WrapperNode(TreeNode treeNode) {
            this.node = treeNode;
        }

        WrapperNode(boolean visited, TreeNode treeNode) {
            this.visited = visited;
            this.node = treeNode;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Stack<WrapperNode> stack = new Stack<>();
        stack.push(new WrapperNode(root));
        while (!stack.isEmpty()) {
            WrapperNode wrapperNode = stack.pop();
            if (wrapperNode.visited) {
                list.add(wrapperNode.node.val);
            } else {
                //后序遍历的顺序是：左子树->右子树->当前节点，因此入栈顺序是：当前节点->右子树->左子树
                stack.push(new WrapperNode(true, wrapperNode.node));
                if (null != wrapperNode.node.right) {
                    stack.push(new WrapperNode(wrapperNode.node.right));
                }
                if (null != wrapperNode.node.left) {
                    stack.push(new WrapperNode(wrapperNode.node.left));
                }
            }
        }
        return list;
    }
}