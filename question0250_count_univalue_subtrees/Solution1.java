package question0250_count_univalue_subtrees;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/count-univalue-subtrees/
 *
 * 递归实现。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：1ms，击败92.75%。消耗内存：36MB，击败100.00%。
 */
public class Solution1 {
    private Set<TreeNode> set = new HashSet<>();    //将所有满足条件的子树的根结点放入该set中

    public int countUnivalSubtrees(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            set.add(root);
            return 1;
        }
        if (null == root.left) {
            int tmp = countUnivalSubtrees(root.right);  //必须提前计算这一项，再去判断set.contains(root.right)，否则set.contains(root.right)的结果一定是false
            if (set.contains(root.right) && root.val == root.right.val) {
                set.add(root);
                return tmp + 1;
            }
            return tmp;
        }
        if (null == root.right) {
            int tmp = countUnivalSubtrees(root.left);
            if (set.contains(root.left) && root.val == root.left.val) {
                set.add(root);
                return tmp + 1;
            }
            return tmp;
        }
        int tmp = countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
        if (set.contains(root.left) && set.contains(root.right) && root.val == root.right.val && root.left.val == root.val) {
            set.add(root);
            return tmp + 1;
        }
        return tmp;
    }
}