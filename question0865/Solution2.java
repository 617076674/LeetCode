package question0865;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-07-28
 *
 * 递归。对于一个节点，如果左子树高度等于右子树高度，这个节点就是答案，如果左子树高度小于右子树高度，查找右子树，否则查找左子树。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中节点个数。
 *
 * 执行用时：4ms，击败22.09%。消耗内存：35.4MB，击败67.65%。
 */
public class Solution2 {
    private Map<Integer, Integer> heightMap = new HashMap<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (null == root) {
            return null;
        }
        int leftHeight = getHeight(root.left), rightHeight = getHeight(root.right);
        if (leftHeight == rightHeight) {
            return root;
        } else if (leftHeight < rightHeight) {
            return subtreeWithAllDeepest(root.right);
        }
        return subtreeWithAllDeepest(root.left);
    }

    private int getHeight(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (heightMap.containsKey(root.val)) {
            return heightMap.get(root.val);
        }
        int result = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        heightMap.put(root.val, result);
        return result;
    }
}
