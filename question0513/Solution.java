package question0513;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qianyihui
 * @date 2019-07-11
 *
 * 层序遍历。
 *
 * 时间复杂度和空间复杂度均为O(n)，其中n为二叉树中的节点个数。
 *
 * 执行用时：2ms，击败82.58%。消耗内存：37.1MB，击败93.33%。
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                if (i == 0) {
                    result = treeNode.val;
                }
                if (null != treeNode.left) {
                    queue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.add(treeNode.right);
                }
            }
        }
        return result;
    }
}
