package question0094_binary_tree_inorder_traversal;

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
    private class WrapperNode {
        boolean visited;        //go, print

        TreeNode node;

        WrapperNode(TreeNode node) {
            this.node = node;
        }

        WrapperNode(boolean visited, TreeNode node) {
            this.visited = visited;
            this.node = node;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
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
                //中序遍历的顺序是：左子树->当前节点->右子树，因此入栈顺序是右子树->当前节点->左子树
                if (null != wrapperNode.node.right) {
                    stack.push(new WrapperNode(wrapperNode.node.right));
                }
                stack.push(new WrapperNode(true, wrapperNode.node));
                if (null != wrapperNode.node.left) {
                    stack.push(new WrapperNode(wrapperNode.node.left));
                }
            }
        }
        return list;
    }
}
