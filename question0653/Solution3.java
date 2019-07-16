package question0653;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author qianyihui
 * @date 2019-07-16
 *
 * 将Solution2用队列来实现。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：15ms，击败32.35%。消耗内存：52MB，击败31.25%。
 */
public class Solution3 {
    public boolean findTarget(TreeNode root, int k) {
        if (null == root) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode treeNode = queue.poll();
                if (set.contains(k - treeNode.val)) {
                    return true;
                }
                set.add(treeNode.val);
                if (null != treeNode.left) {
                    queue.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.add(treeNode.right);
                }
            }
        }
        return false;
    }
}