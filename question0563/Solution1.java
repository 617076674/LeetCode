package question0563;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-07-11
 *
 * 哈希表保存每个节点的和。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：9ms，击败33.49%。消耗内存：36.8MB，击败97.84%。
 */
public class Solution1 {
    private int result = 0;

    private Map<TreeNode, Integer> sumMap = new HashMap<>();

    public int findTilt(TreeNode root) {
        sum(root);
        slope(root);
        return result;
    }

    private void slope(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        if (treeNode.left != null && treeNode.right != null) {
            result += Math.abs(sumMap.get(treeNode.left) - sumMap.get(treeNode.right));
        } else if (treeNode.left == null && treeNode.right != null) {
            result += Math.abs(sumMap.get(treeNode.right));
        } else if (treeNode.left != null) {
            result += Math.abs(sumMap.get(treeNode.left));
        }
        slope(treeNode.left);
        slope(treeNode.right);
    }

    private int sum(TreeNode treeNode) {
        if (null == treeNode) {
            return 0;
        }
        if (sumMap.containsKey(treeNode)) {
            return sumMap.get(treeNode);
        }
        if (treeNode.left == null && treeNode.right == null) {
            sumMap.put(treeNode, treeNode.val);
            return treeNode.val;
        }
        int result = sum(treeNode.left) + sum(treeNode.right) + treeNode.val;
        sumMap.put(treeNode, result);
        return result;
    }
}
