package question1123;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-07-29
 *
 * 和question0865一模一样的题。
 *
 * 执行用时：7ms，击败21.05%。消耗内存：40.6MB，击败100.00%。
 */
public class Solution {
    private Map<Integer, Integer> heightMap = new HashMap<>();

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (null == root) {
            return null;
        }
        int leftHeight = getHeight(root.left), rightHeight = getHeight(root.right);
        if (leftHeight == rightHeight) {
            return root;
        } else if (leftHeight < rightHeight) {
            return lcaDeepestLeaves(root.right);
        }
        return lcaDeepestLeaves(root.left);
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
