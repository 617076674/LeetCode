package question0663_equal_tree_partition;

import java.util.HashSet;
import java.util.Set;

/**
 * 如果树中所有节点的和 total 是一个奇数，显然无法去掉一条边将其分成两颗节点和相同的子树。
 *
 * 如果树中所有节点的和 total 是一个偶数，去寻找一颗子树（不包括原树本身），该子树的节点和为 total 的一半。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：3ms，击败59.09%。消耗内存：40.9MB，击败100.00%
 */
public class Solution {
    private Set<Integer> set = new HashSet<>();

    public boolean checkEqualTree(TreeNode root) {
        int total = sum(root, root);
        if ((total & 1) == 1) {
            return false;
        }
        return set.contains(total >> 1);
    }

    private int sum(TreeNode treeNode, TreeNode root) {
        if (null == treeNode) {
            return 0;
        }
        int result = treeNode.val + sum(treeNode.left, root) + sum(treeNode.right, root);
        if (treeNode != root) {
            set.add(result);
        }
        return result;
    }
}