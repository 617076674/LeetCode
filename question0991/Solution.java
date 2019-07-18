package question0991;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qianyihui
 * @date 2019-07-18
 *
 * 层序遍历。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是二叉树中的节点个数。
 *
 * 执行用时：2ms，击败66.08%。消耗内存：35.1MB，击败75.58%。
 */
public class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        int levelX = -1, levelY = -1, level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null && treeNode.right != null
                        && ((treeNode.left.val == x && treeNode.right.val == y)
                        || (treeNode.left.val == y && treeNode.right.val == x))) {
                    return false;
                }
                if (treeNode.val == x) {
                    levelX = level;
                }
                if (treeNode.val == y) {
                    levelY = level;
                }
                if (null != treeNode.left) {
                    queue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.add(treeNode.right);
                }
            }
            level++;
        }
        if (levelX == -1 || levelY == -1) {
            return false;
        }
        return levelX == levelY;
    }
}
