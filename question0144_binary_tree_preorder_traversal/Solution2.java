package question0144_binary_tree_preorder_traversal;

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

    public List<Integer> preorderTraversal(TreeNode root) {
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
                //前序遍历的顺序是：当前节点->左子树->右子树，因此入栈顺序是右子树->左子树->当前节点
                if (null != wrapperNode.node.right) {
                    stack.push(new WrapperNode(wrapperNode.node.right));
                }
                if (null != wrapperNode.node.left) {
                    stack.push(new WrapperNode(wrapperNode.node.left));
                }
                stack.push(new WrapperNode(true, wrapperNode.node));
            }
        }
        return list;
    }
}
