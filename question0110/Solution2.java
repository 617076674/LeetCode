package question0110;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author qianyihui
 * @date 2019-07-08
 *
 * 由于无法为每个节点保存height值，所以无法通过后序遍历的方式保存各节点的高度值来减少重复计算。
 * 因此，我们用一个哈希表并采用记忆化搜索的方式来减少重复计算次数。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是树中的节点个数。
 *
 * 执行用时：15ms，击败8.95%。消耗内存：41.7MB，击败5.00%。
 */
public class Solution2 {
    private Map<TreeNode, Integer> map = new HashMap<>();

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
        if (map.containsKey(node)) {
            return map.get(node);
        }
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
        map.put(node, levelCount);
        return levelCount;
    }
}
