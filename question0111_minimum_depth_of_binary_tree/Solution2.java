package question0111_minimum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 递归实现。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：1ms，击败99.73%。消耗内存：37.9MB，击败49.88%。
 */
public class Solution2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 1;
        while (true) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    return result;
                }
                if (null != treeNode.left) {
                    queue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.add(treeNode.right);
                }
            }
            result++;
        }
    }
}