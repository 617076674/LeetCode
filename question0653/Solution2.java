package question0653;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qianyihui
 * @date 2019-07-16
 *
 * 用一个set来保存已经遍历过的数字。每遍历一个节点，寻找其另一半是否已经在set中存在。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：12ms，击败47.92%。消耗内存：50.1MB，击败44.93%。
 */
public class Solution2 {
    private Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return find(root, k);
    }

    private boolean find(TreeNode root, int k) {
        if (null == root) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left, k) || find(root.right, k);
    }
}