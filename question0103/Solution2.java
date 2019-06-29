package question0103;

import java.util.*;

/**
 * 双栈实现。在打印一个栈里的节点时，它的子节点保存到另一个栈里。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是二叉树中的节点个数。
 *
 * 执行用时：3ms，击败61.52%。消耗内存：36MB，击败40.11%。
 */
public class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null) {
            return listList;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    TreeNode treeNode = stack1.pop();
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        stack2.push(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        stack2.push(treeNode.right);
                    }
                }
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode treeNode = stack2.pop();
                    list.add(treeNode.val);
                    if (treeNode.right != null) {
                        stack1.push(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        stack1.push(treeNode.left);
                    }
                }
            }
            listList.add(list);
        }
        return listList;
    }
}
