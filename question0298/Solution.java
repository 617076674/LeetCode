package question0298;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-08-12
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：65ms，击败7.14%。消耗内存：52MB，击败100.00%。
 */
public class Solution {
    private Map<TreeNode, Integer> map = new HashMap<>();

    private int maxLength = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return maxLength;
    }

    /**
     * 求以root为根节点的树中，从根节点开始的最长连续序列的长度
     */
    private int dfs(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int result = 1, leftResult = dfs(root.left), rightResult = dfs(root.right);
        if (root.left == null && root.right != null) {
            if (root.val + 1 == root.right.val) {
                result = rightResult + 1;
            }
        } else if (root.right == null && root.left != null) {
            if (root.val + 1 == root.left.val) {
                result = leftResult + 1;
            }
        } else if (root.left != null) {
            if (root.val + 1 == root.right.val) {
                result = rightResult + 1;
            }
            if (root.val + 1 == root.left.val) {
                result = Math.max(result, leftResult + 1);
            }
        }
        maxLength = Math.max(result, maxLength);
        map.put(root, result);
        return result;
    }
}
