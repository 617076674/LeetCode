package question0337_house_robber_iii;

import java.util.HashMap;
import java.util.Map;

/**
 * 记忆化搜索。
 *
 * 两种情况。
 * （1）偷取根节点。
 * （2）不偷取根节点。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n是树中的节点个数。
 *
 * 执行用时：8ms，击败53.24%。消耗内存：41.6MB，击败13.83%。
 */
public class Solution {
    private Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int result;
        if (root.left == null) {
            result = Math.max(root.val + rob(root.right.left) + rob(root.right.right), rob(root.right));
        } else if (root.right == null) {
            result = Math.max(root.val + rob(root.left.left) + rob(root.left.right), rob(root.left));
        } else {
            result = Math.max(root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right), rob(root.left) + rob(root.right));
        }
        memo.put(root, result);
        return result;
    }
}