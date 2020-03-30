package question0337;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-07-22
 *
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
    private Map<TreeNode, Integer> dp = new HashMap<>();

    public int rob(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (dp.containsKey(root)) {
            return dp.get(root);
        }
        int result;
        if (root.left == null) {
            result = Math.max(root.val + rob(root.right.left) + rob(root.right.right), rob(root.right));
        } else if (root.right == null) {
            result = Math.max(root.val + rob(root.left.left) + rob(root.left.right), rob(root.left));
        } else {
            result = Math.max(root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right), rob(root.left) + rob(root.right));
        }
        dp.put(root, result);
        return result;
    }
}
