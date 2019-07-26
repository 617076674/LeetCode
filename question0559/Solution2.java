package question0559;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-07-26
 *
 * 记忆化搜索，避免重复计算。
 *
 * 时间复杂度是O(n)，其中n是树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：7ms，击败8.30%。消耗内存：54.1MB，击败43.18%。
 */
public class Solution2 {
    Map<Node, Integer> map = new HashMap<>();

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int max = 0;
        for (Node node : root.children) {
            max = Math.max(max, maxDepth(node));
        }
        map.put(root, max + 1);
        return max + 1;
    }
}
