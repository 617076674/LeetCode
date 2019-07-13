package question0515;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是树中的节点个数。
 *
 * 执行用时：6ms，击败37.55%。消耗内存：40MB，击败81.76%。
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size(), max = Integer.MIN_VALUE;
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                max = Math.max(max, treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
