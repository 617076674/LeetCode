package question1339_maximum_product_of_splitted_binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为树中的节点个数。
 *
 * 执行用时：42ms，击败15.34%。消耗内存：171.5MB，击败100.00%
 */
public class Solution {
    private Map<TreeNode, Integer> map = new HashMap<>();

    public int maxProduct(TreeNode root) {
        int total = sum(root);
        long result = Long.MIN_VALUE;
        for (int part : map.values()) {
            result = Math.max(((long) part * (total - part)), result);
        }
        return (int) (result % 1000000007);
    }

    private int sum(TreeNode root) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (root.left == null && root.right == null) {
            map.put(root, root.val);
            return root.val;
        }
        int result = root.val;
        if (root.left != null) {
            result += sum(root.left);
        }
        if (root.right != null) {
            result += sum(root.right);
        }
        map.put(root, result);
        return result;
    }
}