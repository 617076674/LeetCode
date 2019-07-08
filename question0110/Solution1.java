package question0110;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是O(n ^ 2)，其中n是树中的节点个数。空间复杂度是O(n)。
 *
 * 执行用时：4ms，击败40.04%。消耗内存：36.4MB，击败96.68%。
 */
public class Solution1 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(calculateDepth(root.left) - calculateDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int levelCount = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int level = queue.size();
            levelCount++;
            while (level > 0) {
                level--;
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return levelCount;
    }
}
