package question0107_binary_tree_level_order_traversal_ii;

import java.util.*;

/**
 * 用栈来逆序输出层序遍历结果。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：5ms，击败10.75%。消耗内存：36.6MB，击败38.87%。
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (null == root) {
            return listList;
        }
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (null != treeNode.left) {
                    queue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.add(treeNode.right);
                }
            }
            stack.add(list);
        }
        while (!stack.isEmpty()) {
            listList.add(stack.pop());
        }
        return listList;
    }
}