package question0102_binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：2ms，击败91.51%。消耗内存：37.2MB，击败42.32%。
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (null == root) {
            return listList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if (null != tmp.left) {
                    queue.add(tmp.left);
                }
                if (null != tmp.right) {
                    queue.add(tmp.right);
                }
            }
            listList.add(list);
        }
        return listList;
    }
}