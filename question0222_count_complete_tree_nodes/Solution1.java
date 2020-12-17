package question0222_count_complete_tree_nodes;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 执行用时：7ms，击败7.97%。消耗内存：41.2MB，击败49.81%。
 */
public class Solution1 {

    public int countNodes(TreeNode root) {
        int result = 0;
        if (null == root) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.add(cur);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            result++;
            if (null != treeNode.left) {
                queue.add(treeNode.left);
            }
            if (null != treeNode.right) {
                queue.add(treeNode.right);
            }
        }
        return result;
    }

}