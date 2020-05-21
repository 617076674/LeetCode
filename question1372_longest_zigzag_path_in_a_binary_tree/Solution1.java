package question1372_longest_zigzag_path_in_a_binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 记忆化搜索。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：81ms，击败100.00%。消耗内存62.7MB，击败100.00%。
 */
public class Solution1 {
    private Map<TreeNode, Integer> leftMap = new HashMap<>(), rightMap = new HashMap<>(), map = new HashMap<>();

    public int longestZigZag(TreeNode root) {
        return longestZigZag(root, 0) - 1;
    }

    private int longestZigZag(TreeNode root, int last) {
        if (last == -1 && leftMap.containsKey(root)) {
            return leftMap.get(root);
        } else if (last == 1 && rightMap.containsKey(root)) {
            return rightMap.get(root);
        } else if (last == 0 && map.containsKey(root)) {
            return map.get(root);
        }
        if (null == root) {
            return 0;
        }
        if (last == 1) {
            int result = 1 + longestZigZag(root.left, -1);
            rightMap.put(root, result);
            return result;
        } else if (last == -1) {
            int result = 1 + longestZigZag(root.right, 1);
            leftMap.put(root, result);
            return result;
        }
        int result = Math.max(1 + Math.max(longestZigZag(root.left, -1), longestZigZag(root.right, 1)),
                Math.max(longestZigZag(root.left, 0), longestZigZag(root.right, 0)));
        map.put(root, result);
        return result;
    }
}