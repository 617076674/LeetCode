package question0226;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 利用队列，分层翻转，和层序遍历很像。
 *
 * 时间复杂度是O(n)，其中n为二叉树中的节点个数。空间复杂度是O(h)，其中h是二叉树的高度。
 *
 * 执行用时：1ms，击败82.20%。消耗内存：35.3MB，击败38.67%。
 */
public class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            TreeNode tmp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tmp;
            if (null != treeNode.left) {
                queue.add(treeNode.left);
            }
            if (null != treeNode.right) {
                queue.add(treeNode.right);
            }
        }
        return root;
    }
}
