package question0110_balanced_binary_tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

/**
 * 由于无法为每个节点保存height值，所以无法通过后序遍历的方式保存各节点的高度值来减少重复计算。因此，我们用一个哈希表并采用记忆化搜索的方式来减少重复计算次数。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是树中的节点个数。
 *
 * 执行用时：3ms，击败7.59%。消耗内存：39.8MB，击败69.11%。
 */
public class Solution1 {
    private Map<TreeNode, Integer> map = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if (Objects.isNull(root)) {
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
        if (Objects.isNull(node)) {
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
                TreeNode tmp = queue.poll();
                if (!Objects.isNull(tmp.left)) {
                    queue.add(tmp.left);
                }
                if (!Objects.isNull(tmp.right)) {
                    queue.add(tmp.right);
                }
            }
        }
        map.put(node, levelCount);
        return levelCount;
    }
}