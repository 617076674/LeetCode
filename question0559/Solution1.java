package question0559;

/**
 * @author qianyihui
 * @date 2019-07-26
 *
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n是树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：3ms，击败57.90%。消耗内存：56.1MB，击败21.60%。
 */
public class Solution1 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node node : root.children) {
            max = Math.max(max, maxDepth(node));
        }
        return max + 1;
    }
}
